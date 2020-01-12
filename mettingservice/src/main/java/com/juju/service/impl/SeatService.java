package com.juju.service.impl;

import com.juju.mapper.SeatMapper;
import com.juju.po.Seat;
import com.juju.service.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SeatService implements ISeatService {
    @Autowired
    private SeatMapper seatMapper;

    @Override
    public List<Seat> findSeatAll() throws Exception {
        return seatMapper.findSeatAll();
    }

    @Override
    public Seat findSeatById(int id) throws Exception {
        return seatMapper.findSeatById(id);
    }

    @Override
    public void addSeat(Seat seat) throws Exception {
        seatMapper.addSeat(seat);
    }

    @Override
    public void updateSeat(Seat seat) throws Exception {
        seatMapper.updateSeat(seat);
    }

    @Override
    public void deleteSeat(int id) throws Exception {
        seatMapper.deleteSeat(id);
    }
}
