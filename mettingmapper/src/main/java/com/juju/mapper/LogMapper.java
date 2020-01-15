package com.juju.mapper;

import com.juju.po.Log;

import java.util.List;

public interface LogMapper {

    /*
        通过用户ID查看用户登录日志
     */
    List<Log> findLogAll(int userId);

}
