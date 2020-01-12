package com.juju.service;

import com.juju.po.Seat;

import java.util.List;

public interface ISeatService {
    /*
        查看所有座次信息
     */
    List<Seat> findSeatAll() throws Exception;
    /*
        通过Id查看座次信息
     */
    Seat findSeatById(int id) throws Exception;
    /*
        增加座次信息
     */
    void addSeat(Seat seat) throws Exception;
    /*
        修改座次信息
     */
    void updateSeat(Seat seat) throws Exception;
    /*
        删除座次信息
     */
    void deleteSeat(int id) throws Exception;
}
