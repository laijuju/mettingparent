package com.juju.service;

import com.juju.po.Perm;

import java.util.List;

public interface IPermService {

    /*
        通过角色的id查找这个的权限
     */
    List<Perm> findPermByRoleId(int roleId) throws Exception;

    /*
        查找所有权限
     */
    List<Perm> findPermsAll() throws Exception;

    /*
        添加一个权限
     */
    void addPerm(Perm perm) throws Exception;

    /*
        删除一个权限
     */
    void deletePerm(int permId) throws Exception;

    /*
        修改一个权限
     */
    void updatePerm(Perm perm) throws Exception;

}
