package com.example.demo.user.service.impl;


import com.example.demo.common.code.TokenCache;
import com.example.demo.common.controller.BaseController;
import com.example.demo.common.exception.UpdateException;
import com.example.demo.common.serverResponse.ServerResponse;
import com.example.demo.common.service.AbstractService;
import com.example.demo.common.util.MD5Util;
import com.example.demo.common.util.RandomUtil;
import com.example.demo.user.entity.User;
import com.example.demo.user.mapper.UserMapper;
import com.example.demo.user.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class UserServiceImpl extends AbstractService<User, UserMapper> implements IUserService {

    @Override
    public ServerResponse insert(User entity) {
        Integer rows = this.checkLoginname(entity.getLoginname());
        if (rows == 1)
            return ServerResponse.createByErrorMessage("登录用户名已被使用，请更换loginName在尝试更新");

     /*  邮箱与手机号码不做为登录条件目前暂时不做校验

       rows = mapper.checkEmail(entity.getEmail());
       if (rows == 1)
            return ServerResponse.createByErrorMessage("邮箱已被使用，请更换email在尝试更新");
        rows = mapper.checkPhone(entity.getPhone());
        if (rows == 1)
            return ServerResponse.createByErrorMessage("手机号码已被使用，请更换phone在尝试更新");*/

        //设置权限,默认为普通用户
        if (entity.getRole()==null )
            entity.setRole(BaseController.USER_ROLE_ORDINARY);

        if (StringUtils.isBlank(entity.getNickname()))
            entity.setNickname(RandomUtil.getRandomCode(6));
        //MD5加密
        entity.setPassword(MD5Util.MD5EncodeUtf8(entity.getPassword()));
        rows = mapper.insert(entity);
        if (rows != 1)
            throw new UpdateException("数据更新时出现异常");
        return ServerResponse.createBySuccess("注册成功");
    }


    @Override
    public ServerResponse deleteByPrimaryKey(Integer id) {
        List<User> userList =  mapper.getListUser();
        if (userList.size()<=1)
            return ServerResponse.createByErrorMessage("用户数量过少无法删除");

        Integer rows = mapper.deleteByPrimaryKey(id);
        if (rows != 1)
            throw new UpdateException("删除时出现未知异常！");
        return ServerResponse.createBySuccess("删除成功！");
    }

    @Override
    public ServerResponse updateByPrimaryKey(User entity) {

        //登录用户名是不能被跟新的,此处的loginname是从原本登录的session中获取
        User updateUser = new User();
        updateUser.setId(entity.getId());
        //TODO 更改邮箱与手机号码需要验证
        updateUser.setEmail(entity.getEmail());
        updateUser.setPhone(entity.getPhone());
        updateUser.setNickname(entity.getNickname());
        //TODO 设置密保此处应该有验证
        if (StringUtils.isNotEmpty(entity.getQuestion()))
            updateUser.setQuestion(entity.getQuestion());
        if (StringUtils.isNotEmpty(entity.getAnswer()))
            updateUser.setAnswer(entity.getAnswer());
        if (entity.getRole()!=null)
            updateUser.setRole(entity.getRole());
        int updateCount = mapper.updateByPrimaryKeySelective(updateUser);
        if (updateCount != 1)
            throw new UpdateException("数据更新时出现异常");
        updateUser.setLoginname(entity.getLoginname());
        return ServerResponse.createBySuccess("更新个人信息成功", updateUser);
    }

    @Override
    public ServerResponse<User> selectByPrimaryKey(Integer id) {
        User user = mapper.selectByPrimaryKey(id);
        if (user == null)
            return ServerResponse.createByErrorMessage("找不到当前用户");
        user.setPassword(StringUtils.EMPTY);//将密码设置掉
        user.setAnswer(StringUtils.EMPTY);//将密保的答案设置掉
        return ServerResponse.createBySuccess(user);
    }


    @Override
    public ServerResponse login(String loginname, String password) {
        if (mapper.checkLoginname(loginname)== 0)
            return ServerResponse.createByErrorMessage("用户名不存在");
        // 密码登录MD5
        User user = mapper.selectLogin(loginname, MD5Util.MD5EncodeUtf8(password));
        if (user == null)
            return ServerResponse.createByErrorMessage("密码错误");
        user.setPassword(StringUtils.EMPTY);//隐藏数据
        user.setAnswer(StringUtils.EMPTY);//将密保的答案设置掉
        return ServerResponse.createBySuccess("登录成功", user);
    }

    @Override
    public ServerResponse<String> selectQuestion(String loginname) {
        Integer rows = this.checkLoginname(loginname);
        if (rows == 0)
            return ServerResponse.createByErrorMessage("用户名不存在");
        String question = mapper.selectQuestionByUsername(loginname);
        if (StringUtils.isNotBlank(question))//非空
            return ServerResponse.createBySuccess(question);
        return ServerResponse.createByErrorMessage("找回密码的问题是空的");
    }

    @Override
    public ServerResponse<String> checkAnswer(String loginname, String question, String answer) {
        int resultCount = mapper.checkAnswer(loginname, question, answer);
        if (resultCount > 0) {
            //说名问题及问题答案是这个用户的，并且是正确的
            String forgetToken = UUID.randomUUID().toString();
            TokenCache.setKey(TokenCache.TOKEN_PREFIX + loginname, forgetToken);
            return ServerResponse.createBySuccess(forgetToken);
        }
        return ServerResponse.createByErrorMessage("问题的答案错误");
    }

    @Override
    public ServerResponse<String> forgetRestPassword(String loginname, String passwordNew, String forgetToken) {
        if (StringUtils.isBlank(forgetToken))//判断是否为空
            return ServerResponse.createByErrorMessage("参数错误，token需要传递");
        Integer rows = this.checkLoginname(loginname);
        if (rows == 0)
            return ServerResponse.createByErrorMessage("用户名不存在");
        String token = TokenCache.getKey(TokenCache.TOKEN_PREFIX + loginname);
        if (StringUtils.isBlank(token))
            return ServerResponse.createByErrorMessage("token无效或过期");
        if (StringUtils.equals(token, forgetToken)) {
            String md5Password = MD5Util.MD5EncodeUtf8(passwordNew);
            int rowCount = mapper.updatePasswordByUsername(loginname, md5Password);
            if (rowCount == 0)
                throw new UpdateException("修改密码失败,出现未知异常");
        } else {
            return ServerResponse.createByErrorMessage("token错误请重新获取重置密码的token");
        }
        return ServerResponse.createByErrorMessage("修改密码成功");
    }

    @Override
    public ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user) {
        //防止横向越权，要校验一下这个用户的旧密码，一定要指定是这个用户，因为我们会查询一个count（1），如果不知道id，那么结果就是true coint>0
        int resultCount = mapper.checkPassword(MD5Util.MD5EncodeUtf8(passwordOld), user.getId());
        if (resultCount == 0)
            return ServerResponse.createByErrorMessage("旧密码错误");
        user.setPassword(MD5Util.MD5EncodeUtf8(passwordNew));
        int updateCount = mapper.updateByPrimaryKeySelective(user);
        if (updateCount > 0)
            return ServerResponse.createBySuccessMessage("更新成功");
        return ServerResponse.createByErrorMessage("密码更新失败");
    }

    @Override
    public ServerResponse<List<User>> getListUser() {
        return ServerResponse.createBySuccess(mapper.getListUser());
    }




    /**
     *   查询登录用户名
     */
    private Integer checkLoginname(String loginname){
        return mapper.checkLoginname(loginname);
    }

}
