package com.example.demo.service;


import com.example.demo.common.serverResponse.ServerResponse;
import com.example.demo.entity.Condition;
import com.example.demo.entity.ResUser;
import java.util.List;

public interface ResDtlService {
    //查询预约明细
    ServerResponse<List<ResUser>> getResDtl(Condition condition);

    //增加预约信息
    ServerResponse addRes(ResUser resUser);

    //删除预约信息
    ServerResponse deleteRes(Integer id);

    //修改预约信息
    ServerResponse updateRes(ResUser resUser);
}
