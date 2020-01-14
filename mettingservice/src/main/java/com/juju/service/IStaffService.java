package com.juju.service;

import com.juju.po.Staff;

import java.util.List;

public interface IStaffService {

    /*
    查询所有的职位
 */
    List<Staff> findStaffAll() throws Exception;

    /*
    通过职位查找职位ID
 */
    int findStaffIdByStaffName(String staffName) throws Exception;

}
