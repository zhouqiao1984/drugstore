package com.drug.store.service;

import com.drug.store.pojo.Complaint;
import com.drug.store.util.Pager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * com.drug.store.service
 *
 * @desc
 * @author:EumJi
 * @year: 2016
 * @month: 11
 * @day: 22
 * @time: 2016/11/22
 */
public interface ComplaintService {
    List<Complaint> getSolvedComplaint(Pager<Complaint> pager, Map<String, Object> paramMap);

    List<Complaint> getPartSolvedComplaint(Pager<Complaint> pager, Map<String, Object> paramMap);

    List<Complaint> getHandingComplaint(Pager<Complaint> pager, Map<String, Object> paramMap);

    List<Complaint> getPartHandingComplaint(Pager<Complaint> pager, Map<String, Object> paramMap);

    Complaint getComplaintById(String id);

    boolean editHandingById(Complaint id);
}
