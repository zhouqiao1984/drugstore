package com.drug.store.service.impl;

import com.drug.store.bean.Drug;
import com.drug.store.mapper.AreaMapper;
import com.drug.store.mapper.AuthorizationMapper;
import com.drug.store.mapper.DrugMapper;
import com.drug.store.mapper.UserRoleMapper;
import com.drug.store.pojo.*;
import com.drug.store.service.DrugService;
import com.drug.store.util.MD5;
import com.drug.store.util.Pager;
import com.drug.store.util.TimeFormatUtil;
import com.drug.store.util.UUIDUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * com.drug.store.service.impl
 *
 * @desc 
 * @author:xhl
 * @year: 2018
 * @month: 05
 * @day: 20
 * @time: 22:52
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DrugServiceImpl implements DrugService {
    @Resource
    private DrugMapper drugMapper;
    @Resource
    private AuthorizationMapper authorizationMapper;
    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private AreaMapper areaMapper;
    @Override
    public List<Drug> getDrugList(Pager<Drug> pager, Map<String, Object> paramMap) {
        List<Drug> drugList = null;
        int result = drugMapper.getDrugCount();
        pager.setTotalCount(result);
        if (result>0) {
            paramMap.put("start",pager.getStart());
            paramMap.put("limit",pager.getLength());
            drugList = drugMapper.getDrugList(paramMap);
        }
        return drugList;
    }

    @Override
    public int insertDrug(Drug drug) throws Exception {
            String time = TimeFormatUtil.formatTime();
            drug.setCreateDate(time);
            //user.setOperateDate(time);
            //user.setId(UUIDUtil.getUUID());
           // user.setPassword(MD5.digest(user.getPassword()));
            

            /*Authorization authorization = new Authorization();
            authorization.setCreator(user.getCreator());
            authorization.setUserRoleId(userRole.getId());
            authorization.setCreateDate(time);
            authorization.setOperateDate(time);
            authorization.setAreaId(user.getAreaId());*/

            int result = drugMapper.insertDrug(drug);

            if (result == 1) {
                 return 1;
            }
        return 0;
    }



    @Override
    public int deleteAdmins(String[] id) throws Exception {
        authorizationMapper.deleteAuthorizations(id);
        userRoleMapper.deleteUserRoles(id);
        int result = drugMapper.getDrugCount();
        if (result>0){
            return result;
        }
        return 0;
    }

    @Override
    public List<User> getSuperAdminList(Pager<User> pager, Map<String, Object> paramMap) {
        List<User> userList = null;
        int count = drugMapper.getDrugCount();
        pager.setTotalCount(count);
        if (count>0){
            paramMap.put("start",pager.getStart());
            paramMap.put("limit",pager.getLength());
            //userList = drugMapper.getSuperDrugList(paramMap);
        }
        return userList;
    }

    /**
     * 超级管理员修改成区域管理员
     * @param userList
     * @return
     * @throws Exception
     */
    @Override
    public int updateSuperToArea(List<User> userList) throws Exception {
        int count =0;
        for (User user : userList) {
            int result = userRoleMapper.updateSuperToArea(user);
            if ( result==1){
                UserRole userRole = userRoleMapper.getUserRole(user.getId());
                if (userRole!=null){
                    Authorization authorization = new Authorization();
                    authorization.setCreator(user.getEditor());
                    authorization.setCreateDate(user.getEditDate());
                    authorization.setUserRoleId(userRole.getId());
                    authorization.setOperateDate(user.getOperateDate());
                    authorization.setAreaId(user.getAreaId());
                    authorizationMapper.insertAuthorization(authorization);
                }
            }
            count++;

        }
        return count;
    }

    /**
     * 分页获取区域管理员列表
     * @param pager
     * @param paramMap
     * @return
     */
    @Override
    public List<User> getAreaAdminsList(Pager<User> pager, Map<String, Object> paramMap) {
        List<User> userList = null;
        int count = 0;//drugMapper.getAreaDrugsCount();
        pager.setTotalCount(count);
        if (count>0){
            paramMap.put("start",pager.getStart());
            paramMap.put("limit",pager.getLength());
            //userList = drugMapper.getAreaDrugsList(paramMap);

            for (User user : userList) {
                Area area = areaMapper.getAreaById(areaMapper.getAreaId(user.getId()));
                user.setArea(area);
            }
        }
        return userList;
    }

    /**
     * 区域管理员修改成超级管理员
     * @param userList
     * @return
     * @throws Exception
     */
    @Override
    public int UpdateAreaToSuper(List<User> userList) throws Exception {
        String[] id = new String[userList.size()];
        for (int i = 0; i < userList.size(); i++) {
            id[i] = userList.get(i).getId();
        }
        int result = authorizationMapper.deleteAuthorizations(id);
        if (result==userList.size()){
            int count = 0;
            for (User user : userList) {
                int result2 = userRoleMapper.UpdateAreaToSuper(user);
                if (result2==1) {
                    count++;
                }
            }
            if (count==userList.size()){
                return count;
            }
        }
        throw new Exception("更新失败");
    }

    @Override
    public int updateAdminArea(AreaIdAndId areaIdAndId) {
        User user = new User();
        user.setId(areaIdAndId.getIds()[0]);
        user.setAreaId(areaIdAndId.getAreasId()[0]);
        int result = authorizationMapper.updateAdminArea(user);
        return result;
    }

}
