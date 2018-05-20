package com.drug.store.mapper;


import com.drug.store.pojo.Manager;
import com.drug.store.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminMapper {

	int validateManager(Manager manager);

	Manager getManagerInfo(Manager manager);

	List<User> getAdminList(Map<String, Object> paramMap);

	int getAdminCount();

	int insertAdmin(User user);

    int deleteAdmins(String[] id);

	int getSuperAdminCount();

	List<User> getSuperAdminList(Map<String, Object> paramMap);

	int getAreaAdminsCount();

	List<User> getAreaAdminsList(Map<String, Object> paramMap);
}
