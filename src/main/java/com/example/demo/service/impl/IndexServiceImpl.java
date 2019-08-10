package com.example.demo.service.impl;

import com.example.demo.common.util.Tools;
import com.example.demo.entity.ResUser;
import com.example.demo.mapper.IndexMapper;
import com.example.demo.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    IndexMapper resUserMapper;

    @Override
    public List<ResUser> getMes() {
        List<ResUser> resList = new ArrayList<ResUser>();
        List<ResUser> list = resUserMapper.getMes();
        System.out.println("list:"+list.toString());
        /*for(ResUser res : list){

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            if("".equals(res.getCreatedOn()) && res.getCreatedOn()!=null){
                String date = formatter.format(res.getCreatedOn());
                res.setDate(date);
            }


        }*/
        for(int i=0;i<=30;i++){
            String date = Tools.getDate(-i);
            int flag = 0;
            for(ResUser res : list){
                if(date.equals(res.getResDate())){
                    Integer UnReserved = 15-Integer.valueOf(res.getReserved());
                    res.setUnreserved(UnReserved.toString());
                    res.setAccount("15");
                    resList.add(res);
                    flag = 1 ;
                    break;
                }

            }
            if (flag == 0){
                ResUser resUser = new ResUser();
                resUser.setAccount("15");
                resUser.setReserved("0");
                resUser.setUnreserved("15");
                resUser.setArrived("0");
                resUser.setUnarrived("0");
                resUser.setResDate(date);
                resList.add(resUser);
            }

        }
        return resList;
    }
}
