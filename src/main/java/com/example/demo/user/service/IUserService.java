package com.example.demo.user.service;

import com.example.demo.common.serverResponse.ServerResponse;
import com.example.demo.common.service.BaseService;
import com.example.demo.user.entity.User;

import java.util.List;


public interface IUserService extends BaseService<User> {

    /**
     * 登录
     */
    ServerResponse login(String loginname, String password);


    /**
     * 查询用户的忘记密码提示问题
     */
    ServerResponse<String> selectQuestion(String loginname);

    /**
     * 效验用户名问题答案
     */
    ServerResponse<String> checkAnswer(String loginname, String question, String answer);

    /**
     * 通过Token更新密码
     */
    ServerResponse<String> forgetRestPassword(String loginname, String passwordNew, String forgetToken);

    /**
     * 登录状态时更新密码
     */
    ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user);

    /**
     * 获取所有用户
     */
    ServerResponse<List<User>> getListUser();


}
