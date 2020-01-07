package com.juju.service.impl;

import com.juju.mapper.PermMapper;
import com.juju.po.Perm;
import com.juju.service.IPermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermService implements IPermService {

    @Autowired
    private PermMapper permMapper;

    @Override
    public List<Perm> findPermByRoleId(int roleId) throws Exception {
        return permMapper.findPermByRoleId(roleId);
    }

    @Override
    public List<Perm> findPermsAll() throws Exception {
        return permMapper.findPermsAll();
    }

    @Override
    public void addPerm(Perm perm) throws Exception {
        permMapper.addPerm(perm);
    }

    @Override
    public void deletePermById(int permId) throws Exception {
        permMapper.deletePermById(permId);
    }

    @Override
    public void updatePerm(Perm perm) throws Exception {
        permMapper.updatePerm(perm);
    }
}
