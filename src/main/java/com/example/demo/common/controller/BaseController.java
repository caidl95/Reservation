package com.example.demo.common.controller;


import com.example.demo.common.code.Const;
import com.example.demo.common.exception.ServiceException;
import com.example.demo.common.exception.UpdateException;
import com.example.demo.common.serverResponse.ServerResponse;
import com.example.demo.common.service.BaseService;
import com.example.demo.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpSession;

/**
 *
 */
public class BaseController <S extends BaseService>{

    @Autowired
    protected S service;

    /**
     * 管理员
     */
    private static final Integer USER_ROLE_ADMIN = 0;

    /**
     * 普通用户
     */
    public static final Integer USER_ROLE_ORDINARY = 1;

    /**
     * 获取当前用户id
     */
    protected final Integer getUidFromSession(HttpSession session) {
        User user = (User)session.getAttribute(Const.SESSION_CURRENT_USER);
        return user.getId();
    }

    /**
     * 获取当前用户
     */
    protected final User getUserFromSession(HttpSession session){
        return (User)session.getAttribute(Const.SESSION_CURRENT_USER);
    }

    /**
     * 判断当前用户是否是管理员
     */
    protected final boolean getRoleAdminFromSession(HttpSession session) {
        User user = (User) session.getAttribute(Const.SESSION_CURRENT_USER);
        if (user == null)
            return false;
        if (USER_ROLE_ADMIN.equals(user.getRole()))
            return true;
        return false;
    }


    /**
     * 统一处理异常
     * @param e
     * @return
     */
    @ExceptionHandler({ServiceException.class})
    public ServerResponse handleException(Throwable e) {
        if (e instanceof UpdateException)
            return ServerResponse.createByErrorMessage(e.getMessage());
        return ServerResponse.createByErrorMessage("未知异常");
    }


}
