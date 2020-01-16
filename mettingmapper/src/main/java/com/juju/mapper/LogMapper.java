package com.juju.mapper;

import com.juju.po.Log;

import java.util.List;

public interface LogMapper {

    /*
        通过用户账号查看用户登录日志
     */
    List<Log> findLogAll(String loginName);

    /*
        记录登录，写入日志
    */
    void addLog(Log log);

}
