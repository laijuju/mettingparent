package com.juju.mapper;

import com.juju.po.Admin;

import java.util.List;

public interface AdminMapper {

    /*
        通过管理员的名字，查找管理员对象
     */
    Admin findAdminByAdminName(String adminName);

    /*
        添加一个管理员账号
     */
    void addAdmin(Admin admin);

    /*
        删除管理员账号
     */
    void deleteAdmin(int adminId);

    /*
        查找所有管理员的账号
     */
    List<Admin> findAdminAll();

    /*
        通过管理员的ID直接更新数据库中的token和过期时间
     */
    void updateTokenAndExpireTime(Admin admin);

    /*
        通过token查询admin对象
     */
    Admin tokenExistOrNot(String token);

    /*
        登录退出,删除token
     */
    void updateToken(String token);
}
