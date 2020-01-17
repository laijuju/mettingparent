package com.juju.service;

import com.juju.po.ActionLog;

import java.util.List;

public interface IActionLogService {


    /*
        记录操作日志
    */
    void addActionLog(ActionLog actionLog) throws Exception;

    /*
        查询操作日志
     */
    List<ActionLog> findActionAll(String adminLoginName) throws Exception;

}
