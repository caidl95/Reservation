package com.example.demo.Controller;

import com.example.demo.common.controller.BaseController;
import com.example.demo.common.serverResponse.ServerResponse;
import com.example.demo.entity.Condition;
import com.example.demo.entity.ResUser;
import com.example.demo.service.IndexService;
import com.example.demo.service.ResDtlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/indexPage")
public class indexController extends BaseController {


    @Autowired
    private IndexService indexService;
    @Autowired
    private ResDtlService resDtlService;
    /*
     * 未来三十天的预约情况
     * */
    @RequestMapping("/index")
    public ServerResponse index(){
        System.out.print("index()");
        List<ResUser> varList = indexService.getMes();
        return ServerResponse.createBySuccess(varList);
    }
    /*
     * 客人预约情况明细
     * */
    @RequestMapping("/resDtl")
    public ServerResponse resDtl(Condition condition){
        System.out.println("resDtl()");
        return resDtlService.getResDtl(condition);
    }
    /*
     * 新增预约
     * */
    @RequestMapping("/resAdd")
    public ServerResponse resAdd(ResUser resUser, HttpSession session){
        System.out.println("resAdd()");
        resUser.setCreatedBy(this.getUserFromSession(session).getLoginname());
        return resDtlService.addRes(resUser);
    }

    /*
     * 删除预约
     * */
    @RequestMapping("/resDelete")
    public ServerResponse resDelete(Integer id){
        System.out.println("resDelete()");
        return resDtlService.deleteRes(id);
    }

    /*
     * 修改预约信息
     * */
    @RequestMapping("/resUpdate")
    public ServerResponse resUpdate(ResUser resUser){
        System.out.println("resUpdate()");
        return resDtlService.updateRes(resUser);
    }
}
