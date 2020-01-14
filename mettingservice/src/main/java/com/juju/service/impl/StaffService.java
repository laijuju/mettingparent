package com.juju.service.impl;

import com.juju.mapper.StaffMapper;
import com.juju.po.Staff;
import com.juju.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StaffService implements IStaffService {

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public List<Staff> findStaffAll() throws Exception {
        return staffMapper.findStaffAll();
    }

    @Override
    public int findStaffIdByStaffName(String staffName) throws Exception {
        return staffMapper.findStaffIdByStaffName(staffName);
    }
}
