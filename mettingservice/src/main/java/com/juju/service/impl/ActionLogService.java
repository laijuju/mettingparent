package com.juju.service.impl;

import com.juju.mapper.ActionLogMapprt;
import com.juju.po.ActionLog;
import com.juju.service.IActionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ActionLogService implements IActionLogService {

    @Autowired
    private ActionLogMapprt actionLogMapprt;

    @Override
    public void addActionLog(ActionLog actionLog) throws Exception {
        actionLogMapprt.addActionLog(actionLog);
    }

    @Override
    public List<ActionLog> findActionAll(String adminLoginName) throws Exception {
        return actionLogMapprt.findActionAll(adminLoginName);
    }
}
