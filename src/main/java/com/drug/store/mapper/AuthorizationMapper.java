package com.drug.store.mapper;

import com.drug.store.pojo.Authorization;
import com.drug.store.pojo.User;
import org.apache.ibatis.annotations.Mapper;

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
public interface AuthorizationMapper {

    int insertAuthorization(Authorization authorization);

    int deleteAuthorizations(String[] id);

    int updateAdminArea(User user);
}
