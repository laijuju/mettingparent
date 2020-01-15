package com.juju.service;

import com.juju.po.Admin;
import com.juju.result.AdminResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IAdminService {

    /*
       通过管理员的名字，查找管理员对象
    */
    Admin findAdminByAdminName(String adminName) throws Exception;

    /*
        添加一个管理员账号
     */
    void addAdmin(Admin admin) throws Exception;

    /*
        删除管理员账号
     */
    void deleteAdmin(int adminId) throws Exception;

    /*
        查找所有管理员的账号
     */
    List<Admin> findAdminAll() throws Exception;

    /*
        管理员登录的方法
     */
    AdminResult login(Admin admin);

    /*
        判断token是否存在
     */
    boolean tokenExistOrNot(String token);

    /*
        删除token,退出登录
     */
    void logout(String token) throws Exception;

    /*
        通过管理员的id查找管理员
     */
    Admin findAdminById(int id) throws Exception;

    /*
        通过ID修改管理员的信息
     */
    void updateAdminById(Admin admin) throws Exception;

    /*
        修改密码
     */
    void updatePassword(String oldPassword, String newPassword, int id) throws Exception;

    /*
        校验密码
     */
    int checkPassword(int id, String adminPassword) throws Exception;

    /*
        添加用户的角色
     */
    void addUserRole(@Param("adminId") int adminId, @Param("roleId") int roleId) throws Exception;

}
