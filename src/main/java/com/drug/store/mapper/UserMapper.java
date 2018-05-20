package com.drug.store.mapper;

import com.drug.store.pojo.LoginUser;
import com.drug.store.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * com.drug.store.mapper
 *
 * @desc
 * @author:EumJi
 * @year: 2016
 * @month: 10
 * @day: 17
 * @time: 2016/10/17
 */
@Mapper
public interface UserMapper {

    User getUser(LoginUser user);

    int updateUser(User user);

    int updatePassword(User user);

    int getAllTenantsCount();

    List<User> getAllTenants(Map<String, Object> paramMap);

    int getPartTenantsCount(Map<String, Object> paramMap);

    List<User> getPartTenants(Map<String, Object> paramMap);

    User getUserById(String id);

    int getAllOwnersCount();

    List<User> getPartOwners(Map<String, Object> paramMap);

    List<User> getAllOwners(Map<String, Object> paramMap);

    int getPartOwnersCount(Map<String, Object> paramMap);

    int insert(User user);
}
