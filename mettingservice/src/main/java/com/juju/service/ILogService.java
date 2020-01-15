package com.juju.service;

import com.juju.po.Log;

import java.util.List;

public interface ILogService {
    /*
        通过用户ID查看用户登录日志
    */
    List<Log> findLogAll(int userId) throws Exception;
}
