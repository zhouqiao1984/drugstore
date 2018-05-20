package com.drug.store.service;

import com.drug.store.pojo.AreaIdAndId;
import com.drug.store.pojo.User;
import com.drug.store.util.Pager;

import java.util.List;
import java.util.Map;

/**
 * com.drug.store.service
 *
 * @desc
 * @author:EumJi
 * @year: 2016
 * @month: 10
 * @day: 25
 * @time: 2016/10/25
 */
public interface AdminService {
    List<User> getAdminList(Pager<User> pager, Map<String, Object> paramMap);

    int insertAdmin(User user) throws Exception;

    int deleteAdmins(String[] id) throws Exception;

    List<User> getSuperAdminList(Pager<User> pager, Map<String, Object> paramMap);

    int updateSuperToArea(List<User> userList) throws Exception;

    List<User> getAreaAdminsList(Pager<User> pager, Map<String, Object> paramMap);

    int UpdateAreaToSuper(List<User> userList) throws Exception;

    int updateAdminArea(AreaIdAndId areaIdAndId);
}
