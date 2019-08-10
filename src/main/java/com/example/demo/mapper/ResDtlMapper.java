package com.example.demo.mapper;

import com.example.demo.entity.Condition;
import com.example.demo.entity.ResUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


public interface ResDtlMapper {

    List<ResUser> getResDtl(Condition condition);

    List<ResUser> getDtlCount(Condition condition);

    Integer addRes(ResUser resUser);

    Integer deleteRes(Integer id);

    Integer updateRes(ResUser resUser);
}
