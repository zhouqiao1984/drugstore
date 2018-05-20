package com.drug.store.service.impl;

import com.drug.store.mapper.AreaMapper;
import com.drug.store.mapper.OrderMapper;
import com.drug.store.mapper.RoomMapper;
import com.drug.store.mapper.UserMapper;
import com.drug.store.pojo.HomeDisplay;
import com.drug.store.service.IndexService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * com.drug.store.service.impl
 *
 * @desc
 * @author:EumJi
 * @year: 2016
 * @month: 10
 * @day: 26
 * @time: 2016/10/26
 */
@Service
public class IndexServiceImpl implements IndexService {
    @Resource
    private RoomMapper roomMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private AreaMapper areaMapper;
    @Override
    public HomeDisplay loadingAllDate() {
        HomeDisplay homeDisplay = new HomeDisplay();
        int ownersCount = userMapper.getAllOwnersCount();
        int tenantsCount = userMapper.getAllTenantsCount();
        int allRoomCount = roomMapper.getAllRoomCount();
        int orderCount = orderMapper.getAllFinishedOrderCount();
        homeDisplay.setOwners(ownersCount);
        homeDisplay.setTenants(tenantsCount);
        homeDisplay.setHouses(allRoomCount);
        homeDisplay.setVolumes(orderCount);

        return homeDisplay;
    }

    /**
     * 获取地区的首页展示信息
     * @param id
     * @return
     */
    @Override
    public HomeDisplay loadingPartInfo(String id) {
        HomeDisplay homeDisplay = new HomeDisplay();
        String areaId = areaMapper.getAreaId(id);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("areaId",areaId);
        paramMap.put("orderStatId",1);
        int partOwnersCount = userMapper.getPartOwnersCount(paramMap);
        int partTenantsCount = userMapper.getPartTenantsCount(paramMap);
        int partRoomCount = roomMapper.getPartRoomCount(areaId);
        int partOutStandingOrderCount = orderMapper.getPartOutStandingOrderCount(paramMap);
        homeDisplay.setOwners(partOwnersCount);
        homeDisplay.setTenants(partTenantsCount);
        homeDisplay.setHouses(partRoomCount);
        homeDisplay.setVolumes(partOutStandingOrderCount);
        return homeDisplay;
    }
}