package com.juju.mapper;

import com.juju.po.Perm;

import java.util.List;

public interface PermMapper {

    /*
        通过角色的id查找这个的权限
     */
    List<Perm> findPermByRoleId(int roleId);

    /*
        查找所有权限
     */
    List<Perm> findPermsAll();

    /*
        添加一个权限
     */
    void addPerm(Perm perm);

    /*
        删除一个权限
     */
    void deletePermById(int permId);

    /*
        修改一个权限
     */
    void updatePerm(Perm perm);

    /*
        通过ID查找权限
     */
    Perm findPermByPermId(int permId);
}
