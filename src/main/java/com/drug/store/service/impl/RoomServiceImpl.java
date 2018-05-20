package com.drug.store.service.impl;

import com.drug.store.mapper.AreaMapper;
import com.drug.store.mapper.OrderMapper;
import com.drug.store.mapper.RoomMapper;
import com.drug.store.mapper.RoomSuppliesMapper;
import com.drug.store.pojo.Room;
import com.drug.store.pojo.RoomSupplies;
import com.drug.store.service.RoomService;
import com.drug.store.service.RoomSuppliesService;
import com.drug.store.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * com.drug.store.service.impl
 *
 * @desc
 * @author:EumJi
 * @year: 2016
 * @month: 10
 * @day: 18
 * @time: 2016/10/18
 */
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private AreaMapper areaMapper;

    @Autowired
    private RoomSuppliesMapper suppliesMapper;

    @Autowired
    private RoomSuppliesService roomSuppliesService;
    @Autowired
    private OrderMapper orderMapper;
    /**
     * 分页获取
     * @param pager
     * @param paramMap
     * @return
     */
    @Override
    public List<Room> getAllRoom(Pager<Room> pager, Map<String, Object> paramMap) {
        List<Room> roomList = null;
        int result = roomMapper.getAllRoomCount();
        pager.setTotalCount(result);
        if (result>0){
            paramMap.put("start",pager.getStart());
            paramMap.put("limit",pager.getLength());
            roomList = roomMapper.getAllRoomList(paramMap);

        }

        return roomList;
    }

    /**
     * 分页获取区域下的分页房间列表
     * 先获取地区下的所有房间
     *
     * @param pager
     * @param paramMap
     * @return
     */
    @Override
    public List<Room> getPartRoom(Pager<Room> pager, Map<String, Object> paramMap) {
        List<Room> roomList = null;
        String areaId = areaMapper.getAreaId((String) paramMap.get("userId"));
        int count = roomMapper.getPartRoomCount(areaId);
        pager.setTotalCount(count);
        if (count>0){
            paramMap.put("areaId",areaId);
            paramMap.put("start",pager.getStart());
            paramMap.put("limit",pager.getLength());
            roomList = roomMapper.getPartRoomList(paramMap);

        }

        return roomList;
    }

    @Override
    public Room getRoomInfoById(String id) {
        Room room = roomMapper.getRoomInfoById(id);
        RoomSupplies roomSupplies = roomSuppliesService.getRoomSuppliesByRoomId(id);
        room.setRoomSupplies(roomSupplies);
        return room;
    }

    @Override
    public int deleteRoomsById(Map<String, String[]> roomsId) {
        int roomresult = 0;
        try {
            int result = roomSuppliesService.deleteSuppliesByRoomId(roomsId);
            int result2 = orderMapper.deleteOrderByRoomId(roomsId);
            roomresult = roomMapper.deleteRoomById(roomsId);
        }catch (Exception e){
            e.printStackTrace();
            return roomresult;
        }

        return roomresult;
    }


    @Override
    public boolean updateRoomState(Room room) {
        int result = roomMapper.updateRoomState(room);
        return result==1? true:false;
    }

    @Override
    public List<Room> getRoomByOwnerId(Pager<Room> pager, Map<String, Object> paramMap) {
        List<Room> roomList = null;
        long count = roomMapper.getOwnerRoomCount(paramMap);
        System.out.println(count);
        pager.setTotalCount((int) count);
        if (count>0){
            paramMap.put("start",pager.getStart());
            paramMap.put("limit",pager.getLength());
            roomList = roomMapper.getRoomByOwnerId(paramMap);

        }
        return roomList;

    }

}
