package com.juju.mapper;

import com.juju.po.Seat;

import java.util.List;

public interface SeatMapper {
    /*
        查看所有座次信息
     */
    List<Seat> findSeatAll();
    /*
        通过Id查看座次信息
     */
    Seat findSeatById(int id);
    /*
        增加座次信息
     */
    void addSeat(Seat seat);
    /*
        修改座次信息
     */
    void updateSeat(Seat seat);
    /*
        删除座次信息
     */
    void deleteSeat(int id);
}
