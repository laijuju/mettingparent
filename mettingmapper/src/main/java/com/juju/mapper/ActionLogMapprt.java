package com.juju.mapper;

import com.juju.po.ActionLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActionLogMapprt {


    /*
        记录操作日志
    */
    void addActionLog(ActionLog actionLog);

    /*
        查询操作日志
     */
    List<ActionLog> findActionAll(@Param("adminLoginName") String adminLoginName);

}
