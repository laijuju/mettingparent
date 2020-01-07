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
        查找多有的角色
      */
     List<Role> findRoleAll();

     /*
        通过roleId查询role
      */
    Role findRoleById(int roleId);
}
