package com.juju.service;

import com.juju.po.Admin;

import java.util.List;

public interface IUserService {
    /*
        添加用户
     */
    void addUser(Admin admin) throws Exception;

    /*
        查看所有用户
     */
    List<Admin> findUserAll() throws Exception;

    /*
        根据用户ID查找用户
     */
    Admin findUserById(int id) throws Exception;

    /*
        根据电话查询用户
     */
    Admin findUserByTel(String userTel) throws Exception;

    /*
        修改用户信息
     */
    void updateUser(Admin admin) throws Exception;

    /*
        删除用户
     */
    void deleteUser(int id) throws Exception;
}
