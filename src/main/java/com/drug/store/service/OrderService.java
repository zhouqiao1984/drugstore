package com.drug.store.service;

import com.drug.store.pojo.Order;
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
 * @day: 23
 * @time: 2016/10/23
 */
public interface OrderService {

    List<Order> getOutstandingOrder(Pager<Order> pager, Map<String, Object> paramMap);

    List<Order> getPartOutStandingOrder(Pager<Order> pager, Map<String, Object> paramMap);

    List<Order> getCompletedOrder(Pager<Order> pager, Map<String, Object> paramMap);

    List<Order> getPartCompletedOrder(Pager<Order> pager, Map<String, Object> paramMap);

    List<Order> getCanceledOrder(Pager<Order> pager, Map<String, Object> paramMap);

    List<Order> getPartCanceledOrder(Pager<Order> pager, Map<String, Object> paramMap);

}
