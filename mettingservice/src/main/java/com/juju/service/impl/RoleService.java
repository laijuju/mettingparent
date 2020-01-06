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
        roleMapper.deleteRole(roleId);
    }

    @Override
    public List<Role> findRoleAll() throws Exception {
        return roleMapper.findRoleAll();
    }
}
