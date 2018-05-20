package com.drug.store.mapper;

import com.drug.store.pojo.User;
import com.drug.store.pojo.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * com.drug.store.mapper
 *
 * @desc
 * @author:EumJi
 * @year: 2016
 * @month: 10
 * @day: 25
 * @time: 2016/10/25
 */
@Mapper
public interface UserRoleMapper {
    int insertUserRole(UserRole userRole);

    int deleteUserRoles(String[] id);

    int updateSuperToArea(User user);

    List<UserRole> getUserRoleUserIds(List<User> userList);

    UserRole getUserRole(String id);

    int UpdateAreaToSuper(User user);
}
