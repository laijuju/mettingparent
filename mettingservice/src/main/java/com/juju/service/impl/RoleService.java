package com.juju.service.impl;

import com.juju.mapper.RoleMapper;
import com.juju.po.Role;
import com.juju.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleService implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findRoleByAdminId(int adminId) throws Exception {
        return roleMapper.findRoleByAdminId(adminId);
    }

    @Override
    public void addRole(Role role) throws Exception {
        roleMapper.addRole(role);
    }

    @Override
    public void deleteRole(int roleId) throws Exception {
        //第一步：先将相关联的关系数据删除掉

        //第二步：删除role本身的数据
        roleMapper.deleteRole(roleId);
    }

    @Override
    public List<Role> findRoleAll() throws Exception {
        return roleMapper.findRoleAll();
    }

    @Override
    public Role findRoleById(int roleId) throws Exception {
        return roleMapper.findRoleById(roleId);
    }

    @Override
    public void updateRoleById(Role role) throws Exception {
        roleMapper.updateRoleById(role);
    }

    @Override
    public void deleteAllPermsByRoleId(int id) throws Exception {
        roleMapper.deleteAllPermsByRoleId(id);
    }

    @Override
    public void addPermsByRoleId(Role role) throws Exception {
        roleMapper.addPermsByRoleId(role);
    }
}
