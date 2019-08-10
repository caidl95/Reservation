package com.example.demo.user.controller;


import com.example.demo.common.code.Const;
import com.example.demo.common.controller.BaseController;
import com.example.demo.common.serverResponse.ServerResponse;
import com.example.demo.user.entity.User;
import com.example.demo.user.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController extends BaseController<IUserService> {

    /**
     * 登录
     * @param session
     * @param loginname
     * @param password
     * @return
     */
    @PostMapping("/login")
    public ServerResponse<User> login(HttpSession session, String loginname, String password){
        ServerResponse<User> response = service.login(loginname,password);
        if (response.isSuccess())
            session.setAttribute(Const.SESSION_CURRENT_USER,response.getData());
        return response;
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @PostMapping("/logout")
    public ServerResponse<String> logout(HttpSession session){
        session.removeAttribute(Const.SESSION_CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    /**
     * 添加一个新用户
     * @param user
     * @return
     */
    @PostMapping("/reg")
    public ServerResponse<String> register(User user){
        return service.insert(user);
    }

    /**
     * 获取当前登录用户信息
     * @param session
     * @return
     */
    @GetMapping("/get_user")
    public ServerResponse<User> getUserInfo(HttpSession session){
        return ServerResponse.createBySuccess(getUserFromSession(session));
    }

    /**
     * 根据用户名获取密保问题
     * @param loginname
     * @return
     */
    @GetMapping("/forget_get_question")
    public ServerResponse<String> forgetGetQuestion(String loginname){
        return service.selectQuestion(loginname);
    }

    /**
     * 根据用户名密保问题答案验证身份
     * @param loginname
     * @param question
     * @param answer
     * @return token
     */
    @PostMapping("/forget_check_answer")
    public ServerResponse<String> forgetCheckAnswer(String loginname,String question,String answer){
        return service.checkAnswer(loginname,question,answer);
    }

    /**
     * 根据用户名token 更改新的密码
     */
    @PostMapping("/forget_rest_password")
    public ServerResponse<String> forgetRestPassword(String loginname,String passwordNew,String forgetToken){
        return service.forgetRestPassword(loginname,passwordNew,forgetToken);
    }

    /**
     * 在线更改密码
     * @param session
     * @param passwordOld
     * @param passwordNew
     * @return
     */
    @PostMapping("/reset_password")
    public ServerResponse<String> resetPassword(HttpSession session, String passwordOld, String passwordNew){
        return service.resetPassword(passwordOld,passwordNew,getUserFromSession(session));
    }

    /**
     * 在线更新用户个人信息
     * @param session
     * @param user
     * @return
     */
    @PostMapping("/update_information")
    public ServerResponse<User> updateInformation(HttpSession session, User user){
        User currentUser = getUserFromSession(session);
        user.setId(currentUser.getId());
        user.setLoginname(currentUser.getLoginname());
        ServerResponse response = service.updateByPrimaryKey(user);
        if (response.isSuccess())
            session.setAttribute(Const.SESSION_CURRENT_USER,response.getData());
        return response;
    }



    @GetMapping("/")
    public ServerResponse<List<User>> getListUser(){
        return service.getListUser();
    }

    @GetMapping("/delete")
    public ServerResponse delete(Integer id){
        return service.deleteByPrimaryKey(id);
    }

    @GetMapping("/get_user_id")
    public ServerResponse<User> getUser(Integer id){
        return service.selectByPrimaryKey(id);
    }

    @PostMapping("/update_id")
    public ServerResponse updateById(HttpSession session,User user){
        if (getRoleAdminFromSession(session)){
            return service.updateByPrimaryKey(user);
        }
        return ServerResponse.createByErrorMessage("无此操作权限！");
    }

}
