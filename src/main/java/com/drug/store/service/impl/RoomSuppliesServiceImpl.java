package com.drug.store.service.impl;

import com.drug.store.mapper.RoomSuppliesMapper;
import com.drug.store.pojo.RoomSupplies;
import com.drug.store.service.RoomSuppliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * com.drug.store.service.impl
 *
 * @desc
 * @author:EumJi
 * @year: 2016
 * @month: 10
 * @day: 21
 * @time: 2016/10/21
 */
@Service
public class RoomSuppliesServiceImpl implements RoomSuppliesService{
    @Autowired
    private RoomSuppliesMapper suppliesMapper;

    public RoomSupplies getRoomSuppliesByRoomId(String roomId) {
        RoomSupplies supplies = suppliesMapper.getRoomSuppliesByRoomId(roomId);
        return supplies;
    }

    @Override
    public int deleteSuppliesByRoomId(Map<String, String[]> roomsId) {
        int result = 0;
        try {
            result = suppliesMapper.deleteSuppliesByRoomId(roomsId);
        }catch (Exception e){
            e.printStackTrace();
            return result;
        }

        return result;
    }
}
