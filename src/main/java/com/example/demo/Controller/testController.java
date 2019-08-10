package com.example.demo.Controller;

import com.example.demo.mapper.test;
import com.example.demo.service.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testController {


    @Autowired
    test test;


    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        System.out.print("test()");
        String name = test.getById();
        System.out.print("name:"+name);
        return null;
    }
}
