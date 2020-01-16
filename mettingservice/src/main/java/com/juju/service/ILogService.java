package com.juju.service;

import com.juju.po.Log;

import java.util.List;

public interface ILogService {
    /*
        通过用户ID查看用户登录日志
    */
    List<Log> findLogAll(String loginName) throws Exception;

    /*
        记录登录，写入日志
    */
    void addLog(Log log) throws Exception;
}
