package com.example.demo.mapper;

import com.example.demo.entity.ResUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


public interface IndexMapper {

    List<ResUser> getMes();
}
