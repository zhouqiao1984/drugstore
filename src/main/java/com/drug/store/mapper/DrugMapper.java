package com.drug.store.mapper;


import com.drug.store.bean.Drug;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DrugMapper {

//	int validateManager(Manager manager);
//
//	Manager getManagerInfo(Manager manager);
//
	List<Drug> getDrugList(Map<String, Object> paramMap);

	int getDrugCount();

	int insertDrug(Drug drug);

//    int deleteDrugs(String[] id);
//
//	int getSuperDrugCount();
//
//	List<User> getSuperDrugList(Map<String, Object> paramMap);
//
//	int getAreaDrugsCount();
//
//	List<User> getAreaDrugsList(Map<String, Object> paramMap);
}
