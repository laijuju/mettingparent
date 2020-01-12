package com.juju.service.impl;

import com.juju.mapper.DelegationMapper;
import com.juju.po.Delegation;
import com.juju.service.IDelegationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DelegationService implements IDelegationService {

    @Autowired
    private DelegationMapper delegationMapper;

    @Override
    public List<Delegation> findDelegationAll() throws Exception {
        return delegationMapper.findDelegationAll();
    }

    @Override
    public Delegation findDelegationById(int id) throws Exception {
        return delegationMapper.findDelegationById(id);
    }

    @Override
    public void addDelegation(Delegation delegation) throws Exception {
        delegationMapper.addDelegation(delegation);
    }

    @Override
    public void updateDelegation(Delegation delegation) throws Exception {
        delegationMapper.updateDelegation(delegation);
    }

    @Override
    public void deleteDelegation(int id) throws Exception {
        delegationMapper.deleteDelegation(id);
    }
}
