package com.example.demo.config;

import com.example.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截路径：必须登录才可以访问
        List<String> patterns = new ArrayList<>();
        patterns.add("/**");

        // 白名单：在黑名单范围内，却不需要登录就可以访问
        List<String> excludePatterns = new ArrayList<>();
        //样式
        excludePatterns.add("/assets/**");
        excludePatterns.add("/dialog.js-master/**");
        excludePatterns.add("/css/**");
        excludePatterns.add("/js/**");
        excludePatterns.add("/err/**");
        excludePatterns.add("/web/css/**");
        excludePatterns.add("/web/js/**");
        excludePatterns.add("/bootstrap-3.3.7-dist/**");
        excludePatterns.add("/Font-Awesome-master/**");

        //接口
        excludePatterns.add("/users/reg");
        excludePatterns.add("/users/login");
        excludePatterns.add("/users/check_valid");
        excludePatterns.add("/users/forget_get_question");
        excludePatterns.add("/users/forget_check_answer");
        excludePatterns.add("/users/forget_rest_password");
        //页面
        excludePatterns.add("/index.html");
        excludePatterns.add("/web/reg.html");
        excludePatterns.add("/web/get_question.html");

        // 注册拦截器
        registry
                .addInterceptor(new LoginInterceptor())
                .addPathPatterns(patterns)
                .excludePathPatterns(excludePatterns);
    }

}





