package com.juju.service;

import com.juju.po.Role;

import java.util.List;

public interface IRoleService {

    /*
        通过管理员的账号查找这个管理员的角色
     */
    List<Role> findRoleByAdminId(int adminId) throws Exception;

    /*
       添加角色
     */
    void addRole(Role role) throws Exception;

    /*
       删除一个角色
     */
    void deleteRole(int roleId) throws Exception;

    /*
       查找多有的角色
     */
    List<Role> findRoleAll() throws Exception;

    /*
        通过roleId查询role
     */
    Role findRoleById(int roleId) throws Exception;

    /*
        通过roleID修改角色信息
     */
    void updateRoleById(Role role) throws Exception;
}
