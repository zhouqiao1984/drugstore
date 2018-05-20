package com.drug.store.service;

import com.drug.store.pojo.Room;
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
 * @month: 10
 * @day: 18
 * @time: 2016/10/18
 */
public interface RoomService {
    List<Room> getAllRoom(Pager<Room> pager, Map<String, Object> paramMap);
    List<Room> getPartRoom(Pager<Room> pager, Map<String, Object> paramMap);

    Room getRoomInfoById(String id);

    int deleteRoomsById(Map<String, String[]> roomsId);

    boolean updateRoomState(Room room);

    List<Room> getRoomByOwnerId(Pager<Room> pager, Map<String, Object> paramMap);

}
