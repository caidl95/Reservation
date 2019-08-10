package com.example.demo.service;

import com.example.demo.mapper.test;
import com.example.demo.service.impl.testImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class testService implements testImpl {
    @Autowired
    private test test;

    @Override
    public String getById() {
        
        return null;
    }
}
