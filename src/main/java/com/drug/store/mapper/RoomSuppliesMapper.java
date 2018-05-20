package com.drug.store.mapper;

import com.drug.store.pojo.RoomSupplies;
import org.apache.ibatis.annotations.Mapper;

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
public interface RoomSuppliesMapper {

    RoomSupplies getRoomSuppliesByRoomId(String roomId);

    int deleteSuppliesByRoomId(Map<String, String[]> roomsId);
}
