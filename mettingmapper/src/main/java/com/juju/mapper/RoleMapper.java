package com.juju.mapper;

/*
    角色的mapper
 */

import com.juju.po.Role;

import java.util.List;

public interface RoleMapper {

    /*
        通过管理员的账号查找这个管理员的角色
     */
    List<Role> findRoleByAdminId(int adminId);

     /*
        添加角色
      */
     void addRole(Role role);

     /*
        删除一个角色
      */
     void deleteRole(int roleId);

     /*
        查找所有的角色
      */
     List<Role> findRoleAll();

     /*
        通过roleId查询role
      */
    Role findRoleById(int roleId);

    /*
        通过roleId修改角色信息
     */
    void updateRoleById(Role role);

    /*
        通过角色的ID删除角色的所有权限
     */
    void deleteAllPermsByRoleId(int id);

    /*
        根据角色ID赋予权限
     */
    void addPermsByRoleId(Role role);
}
