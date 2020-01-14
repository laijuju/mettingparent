package com.juju.mapper;

import com.juju.po.Staff;

import java.util.List;

public interface StaffMapper {

    /*
        查询所有的职位
     */
    List<Staff> findStaffAll();

    /*
        通过职位查找职位ID
     */
    int findStaffIdByStaffName(String staffName);
}
