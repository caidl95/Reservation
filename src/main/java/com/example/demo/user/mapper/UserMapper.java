package com.example.demo.user.mapper;

import com.example.demo.common.dao.BaseMapper;
import com.example.demo.user.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    Integer checkLoginname(String loginname);

    Integer checkEmail(String email);

    User selectLogin(@Param("loginname") String loginname, @Param("password") String password);

    User selectPhoneLogin(String phone);

    String selectQuestionByUsername(String loginname);

    Integer checkAnswer(@Param("loginname") String loginname, @Param("question") String question, @Param("answer") String answer);

    Integer updatePasswordByUsername(@Param("loginname") String loginname, @Param("passwordNew") String passwordNew);

    Integer checkPassword(@Param(value = "password") String password, @Param("userId") Integer userId);

    Integer checkEmailByUserId(@Param(value = "email") String email, @Param(value = "userId") Integer userId);

    Integer checkPhoneByUserId(@Param(value = "phone") String phone, @Param(value = "userId") Integer userId);

    Integer checkPhone(String phone);

    List<User> getListUser();

}
