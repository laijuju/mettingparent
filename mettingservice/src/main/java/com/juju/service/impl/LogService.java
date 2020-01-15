package com.juju.service.impl;

import com.juju.mapper.LogMapper;
import com.juju.po.Log;
import com.juju.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LogService implements ILogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public List<Log> findLogAll(int userId) throws Exception {
        return logMapper.findLogAll(userId);
    }
}
