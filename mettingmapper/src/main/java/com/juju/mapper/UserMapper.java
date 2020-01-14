package com.juju.mapper;

import com.juju.po.Admin;

import java.util.List;

public interface UserMapper {

    /*
        添加用户
     */
    void addUser(Admin admin);

    /*
        查看所有用户
     */
    List<Admin> findUserAll();

    /*
        根据用户ID查找用户
     */
    Admin findUserById(int id);

    /*
        根据电话查询用户
     */
    Admin findUserByTel(String userTel);

    /*
        修改用户信息
     */
    void updateUser(Admin admin);

    /*
        删除用户
     */
    void deleteUser(int id);

    /*
        通过职位名称查询职位Id
     */
    int findStaffIdByStaffName(String staffName);

    /*
        通过代表团名称查询代表团Id
     */
    int findDelegationIdByDelName(String delName);

}
