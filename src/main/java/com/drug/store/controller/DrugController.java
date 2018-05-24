package com.drug.store.controller;

import com.drug.store.bean.Drug;
import com.drug.store.pojo.AreaIdAndId;
import com.drug.store.pojo.Result;
import com.drug.store.pojo.User;
import com.drug.store.service.DrugService;
import com.drug.store.util.Constant;
import com.drug.store.util.DataTableResult;
import com.drug.store.util.Pager;
import com.drug.store.util.TimeFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * com.drug.store.controller
 *
 * @desc
 * @author:EumJi
 * @year: 2016
 * @month: 10
 * @day: 25
 * @time: 2016/10/25
 */
@Controller
@Transactional(rollbackFor = Exception.class)
public class DrugController {


    @Autowired
    private DrugService drugService;

    /**
     * 分页获取药品列表
     * @param pager 分页对象
     * @param session
     * @return
     */
    @RequestMapping(value = "/drugs",method = RequestMethod.POST)
    @ResponseBody
    public DataTableResult<Drug> getAdminList(@RequestBody Pager<Drug> pager, HttpSession session){
        List<Drug> drugList = null;
        DataTableResult tableResult = new DataTableResult();
        User user = (User) session.getAttribute(Constant.USERINFO);
        Map<String, Object> paramMap = new HashMap<>();
        drugList = drugService.getDrugList(pager, paramMap);
        if (drugList!=null&&!drugList.isEmpty()) {
            for (Drug drug1 : drugList) {
                drug1.setCreateDate(TimeFormatUtil.timeFormat(drug1.getCreateDate()));
            }
            tableResult.setRecordsFiltered(drugList.size());
            tableResult.setData(drugList);
        }
            tableResult.setDraw(pager.getDraw());
            tableResult.setDraw(pager.getDraw());
        tableResult.setRecordsTotal(pager.getTotalCount());
        return tableResult;

    }

    /**
     * 添加药品
     * @param user  药品对象信息
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/drug/add",method = RequestMethod.POST)
    @ResponseBody
    public Result insertAdmin(@RequestBody Drug drug,HttpSession session) throws Exception {
        User user1 = (User) session.getAttribute(Constant.USERINFO);

        drug.setCreator(user1.getUserName());
            int result;
            result = drugService.insertDrug(drug);
            if (result == 1){
                return new Result(Constant.SUCCESS_CODE,Constant.DEAL_SUCCESS);
            }
        return new Result(Constant.FAIL_CODE,Constant.DEAL_FAIL);
    }

    /**
     * s删除管理员对象
     * @param id
     * @param session
     * @return
     */
//    @RequestMapping(value = "/admin/delete",method = RequestMethod.POST)
//    @ResponseBody
//    public Result deleteAdmin(@RequestBody String[] id,HttpSession session){
//        try {
//            int resul = drugService.deleteAdmins(id);
//            if (resul==id.length){
//                return new Result(Constant.SUCCESS_CODE,Constant.DEAL_SUCCESS);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new Result(Constant.FAIL_CODE,Constant.DEAL_FAIL);
//        }
//        return new Result(Constant.FAIL_CODE,Constant.DEAL_FAIL);
//    }

    /**
     * 分页获取管理员列表
     * @param pager
     * @param session
     * @return
     */
//    @RequestMapping(value = "/superAdmins",method = RequestMethod.POST)
//    @ResponseBody
//    public DataTableResult<User> getSuperAdminList(@RequestBody Pager<User> pager, HttpSession session){
//        Map<String, Object> paramMap = new HashMap<>();
//        List<User> userList = null;
//        User user = (User) session.getAttribute(Constant.USERINFO);
//        DataTableResult<User> tableResult = new DataTableResult<>();
//        if (user.getUserRoleTypeId()==3) {
//            userList = drugService.getSuperAdminList(pager,paramMap);
//            if (userList!=null&&!userList.isEmpty()){
//                tableResult.setRecordsFiltered(userList.size());
//                tableResult.setData(userList);
//            }
//        }
//        tableResult.setDraw(pager.getDraw());
//        tableResult.setRecordsTotal(pager.getTotalCount());
//        return tableResult;
//    }

    /**
     * 将超级管理员变成区域管理员
     * @param areaIdAndId 区域id和id
     * @param session
     * @return
     */
//    @RequestMapping(value = "/superToArea",method = RequestMethod.POST)
//    @ResponseBody
//    public Result superToArea(@RequestBody AreaIdAndId areaIdAndId, HttpSession session){
//        User users = (User) session.getAttribute(Constant.USERINFO);
//        String[] areasId = areaIdAndId.getAreasId();
//        String[] ids = areaIdAndId.getIds();
//        List<User> userList = new ArrayList<>();
//        for (int i = 0; i < areasId.length; i++) {
//            User user = new User();
//            user.setId(ids[i]);
//            user.setAreaId(areasId[i]);
//            user.setEditor(users.getUserName());
//            user.setEditDate(TimeFormatUtil.formatTime());
//            user.setOperateDate(user.getEditDate());
//            userList.add(user);
//        }
//        try {
//            int count = drugService.updateSuperToArea(userList);
//            if (count==areasId.length){
//                return new Result(Constant.SUCCESS_CODE,Constant.DEAL_SUCCESS);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new Result(Constant.FAIL_CODE,Constant.DEAL_FAIL);
//        }
//
//        return new Result(Constant.FAIL_CODE,Constant.DEAL_FAIL);
//    }

    /**
     * 分页获取管理员列表
     * @param pager 管理员列表
     * @param session
     * @return
     */
//    @RequestMapping(value = "/areaAdmins",method = RequestMethod.POST)
//    @ResponseBody
//    public DataTableResult<User> getAreaAdminsList(@RequestBody Pager<User> pager,HttpSession session){
//        DataTableResult<User> tableResult = new DataTableResult<>();
//        User user = (User) session.getAttribute(Constant.USERINFO);
//        Map<String, Object> paramMap = new HashMap<>();
//        if (user.getUserRoleTypeId()==3){
//            List<User> userList = drugService.getAreaAdminsList(pager, paramMap);
//            if (userList!=null&&!userList.isEmpty()){
//
//                for (User user1 : userList) {
//                    user1.setCreateDate(TimeFormatUtil.timeFormat(user1.getCreateDate()));
//                }
//                tableResult.setDraw(pager.getDraw());
//                tableResult.setRecordsFiltered(userList.size());
//                tableResult.setData(userList);
//            }
//            tableResult.setRecordsTotal(pager.getTotalCount());
//        }
//
//        return tableResult;
//    }

    /**
     * 区域管理员修改成超级管理员
     * @param ids 管理员id数组
     * @param session
     * @return
     */
//    @RequestMapping(value = "/areaToSuper")
//    @ResponseBody
//    public Result updateAreaToSuper(@RequestBody String[] ids,HttpSession session){
//        User users = (User) session.getAttribute(Constant.USERINFO);
//        List<User> userList = new ArrayList<>();
//        for (int i = 0; i < ids.length; i++) {
//            User user = new User();
//            user.setId(ids[i]);
//            user.setEditor(users.getUserName());
//            user.setEditDate(TimeFormatUtil.formatTime());
//            user.setOperateDate(user.getEditDate());
//            userList.add(user);
//        }
//        if (users.getUserRoleTypeId()==3){
//            try {
//                int result = drugService.UpdateAreaToSuper(userList);
//                if (result==ids.length){
//                    return new Result(Constant.SUCCESS_CODE,Constant.DEAL_SUCCESS);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//                return new Result(Constant.FAIL_CODE,Constant.DEAL_FAIL);
//            }
//        }
//        return new Result(Constant.FAIL_CODE,Constant.DEAL_FAIL);
//
//    }

    /**
     * 管理员更新管理区域
     * @param areaIdAndId
     * @param session
     * @return
     */

//    @RequestMapping(value = "/admin/areaUpdate")
//    @ResponseBody
//    public Result updateAdminArea(@RequestBody AreaIdAndId areaIdAndId, HttpSession session){
//        User user = (User) session.getAttribute(Constant.USERINFO);
//        if (user.getUserRoleTypeId()==3) {
//            int result = drugService.updateAdminArea(areaIdAndId);
//            if (result==1){
//                return new Result(Constant.SUCCESS_CODE,Constant.DEAL_SUCCESS);
//            }
//        }
//        return new Result(Constant.FAIL_CODE,Constant.DEAL_FAIL);
//    }

}
