package com.juju.mapper;

import com.juju.po.Admin;
import org.apache.ibatis.annotations.Param;

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

    /*
        通过Id查询管理员
     */
    Admin findAdminById(int id);

    /*
        通过Id修改管理员信息
     */
    void updateAdminById(Admin admin);

    /*
        通过Id修改密码
     */
    void updatePassword(@Param("oldPassword") String oldPassword, @Param("newPassword") String newPassword, @Param("id") int id);

    /*
        校验密码
     */
    String checkPassword(@Param("id") int id);

    /*
        添加用户的角色
     */
    void addUserRole(@Param("adminId") int adminId,@Param("roleId") int roleId);

    /*
        修改最后一次登录时间
     */
    void updateLastLoginTime(Admin admin);

    /*
        记录登录，写入日志
     */
    void addLog(Admin admin);
}
