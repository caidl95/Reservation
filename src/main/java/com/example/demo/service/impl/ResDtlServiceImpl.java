package com.example.demo.service.impl;


import com.example.demo.common.exception.UpdateException;
import com.example.demo.common.serverResponse.ServerResponse;
import com.example.demo.entity.Condition;
import com.example.demo.entity.ResUser;
import com.example.demo.mapper.ResDtlMapper;
import com.example.demo.service.ResDtlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ResDtlServiceImpl implements ResDtlService {

    @Autowired
    private ResDtlMapper resDtlMapper;

    @Override
    public ServerResponse<List<ResUser>> getResDtl(Condition condition) {
        String date;
        int count=0;
        //如果参数值为空则改为null
        if("".equals(condition.getBarCode())){
            condition.setBarCode(null);
        }
        if("".equals(condition.getIdentity())){
            condition.setIdentity(null);
        }
        if("".equals(condition.getName())){
            condition.setName(null);
        }
        if("".equals(condition.getPhone())){
            condition.setPhone(null);
        }
        if("".equals(condition.getID())){
            condition.setID(null);
        }
        //如果开始日期和结束日期有一个为空，则将日期都设为不为空的那一天
        if("".equals(condition.getDateS()) || condition.getDateS()==null || "".equals(condition.getDateE()) || condition.getDateE()==null){
            //如果开始日期和结束日期都为空，则将日期都设为不限日期
            if(("".equals(condition.getDateS()) || condition.getDateS()==null) && ("".equals(condition.getDateE()) || condition.getDateE()==null)){
                String d = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                condition.setDateS("1900-01-01");
                condition.setDateE("2200-01-01");
            }else if("".equals(condition.getDateS()) || condition.getDateS()==null){
                //如果开始日期为空结束日期不为空，则将日期都设为结束日期之前的日期
                //String d = condition.getDateE();
                condition.setDateS("1900-01-01");
            }else if("".equals(condition.getDateE()) || condition.getDateE()==null){
                //如果结束日期为空开始日期不为空，则将日期都设为开始日期之后的日期
                //String d = condition.getDateS();
                condition.setDateE("2200-01-01");
            }
        }
        //condition.setName("李四");
        System.out.println("ResUser:"+condition);
        //查询结果
        List<ResUser> list = resDtlMapper.getResDtl(condition);
        //每天预约的数量
        List<ResUser> accountList = resDtlMapper.getDtlCount(condition);
        //Date类型转换为字符砖类型
        /*for(ResUser res : list){

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = formatter.format(res.getResDate());
            res.setDate(date);

        }*/
        //将每天的客人数量写入查询结果中
        for(ResUser countRes : accountList){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = formatter.format(countRes.getCreatedOn());
            for(ResUser res : list){
                if(date.equals(res.getDate())){
                    res.setAccount(countRes.getAccount());
                }

            }
        }
        System.out.println("resDtl:"+list);
        return ServerResponse.createBySuccess(list);
    }

    @Override
    public ServerResponse addRes(ResUser resUser) {
        //获取当前时间
        resUser.setCreatedOn(new Date());
        //设置新增客户默认值
        if("".equals(resUser.getNation()) || resUser.getNation()==null){
            resUser.setNation("汉");
        }
        if("".equals(resUser.getStatus()) || resUser.getStatus()==null){
            resUser.setStatus("0");
        }
        if("已到".equals(resUser.getStatus())){
            resUser.setStatus("1");
        }
        if("未到".equals(resUser.getStatus())){
            resUser.setStatus("0");
        }
        /*resUser.setIdentity("");
        resUser.setAddr("");
        resUser.seteMail("");
        resUser.setBornDate("");
        resUser.setIsMarry("");
        resUser.setCombinItemCode("");
        resUser.setModifiedBy("");*/
        Integer addR = resDtlMapper.addRes(resUser);
        if (addR != 1)
            throw new UpdateException("增加预约信息时出现未知异常!");
        //Integer addR = resDtlMapper.addRes(resUser);
        return ServerResponse.createBySuccess("添加成功！");
    }

    @Override
    public ServerResponse deleteRes(Integer id) {
        /*Condition con = new Condition();
        con.setName("江流儿");
        Integer deleteR = resDtlMapper.deleteRes(con);
        System.out.println("deleteR:"+deleteR);*/
        Integer deleteR = resDtlMapper.deleteRes(id);
        if (deleteR != 1)
            throw new UpdateException("删除预约信息时出现未知异常！");
        return ServerResponse.createBySuccess("删除预约信息成功！");
    }

    @Override
    public ServerResponse updateRes(ResUser resUser) {
        /*ResUser user = new ResUser();
        user.setID(16);
        user.setName("哪吒");*/
        System.out.println("ResUser::"+resUser.toString());
        Integer updateR = resDtlMapper.updateRes(resUser);
        if (updateR != 1)
            throw new UpdateException("修改预约信息时出现未知异常！");
        return ServerResponse.createBySuccess("修改预约信息成功！");
    }

}
