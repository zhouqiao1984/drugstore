package com.drug.store.controller;

import com.drug.store.pojo.HomeDisplay;
import com.drug.store.pojo.Result;
import com.drug.store.pojo.User;
import com.drug.store.service.IndexService;
import com.drug.store.util.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * com.drug.store.controller
 *
 * @desc
 * @author:EumJi
 * @year: 2016
 * @month: 10
 * @day: 16
 * @time: 2016/10/16
 */
@Controller
public class IndexController {

    @Resource
    private IndexService indexService;


    @RequestMapping("/home/loading")
    @ResponseBody
    public Result loadingDate(HttpSession session){
        HomeDisplay homeDisplay = null;
        User user = (User) session.getAttribute(Constant.USERINFO);
        if (user.getUserRoleTypeId()==3){
            homeDisplay = indexService.loadingAllDate();

        }else if(user.getUserRoleTypeId()==4){
            homeDisplay = indexService.loadingPartInfo(user.getId());

        }
        if (homeDisplay!=null){
            return new Result("success",Constant.DEAL_SUCCESS,homeDisplay);
        }
        return new Result("fail",Constant.DEAL_FAIL);
    }
    @RequestMapping(value = "/session/error",method = RequestMethod.GET)
    public void redirectLogin(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print("window.location.href='localhost:8080'");
        writer.flush();

    }
}
