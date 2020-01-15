package com.juju.control;

import com.juju.po.Log;
import com.juju.result.LogResult;
import com.juju.service.ILogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "登录日志接口功能测试",description = "登录日志接口功能测试")
public class LogController {

    @Autowired
    private ILogService logService;

    Logger logger = Logger.getLogger(LogController.class);

    @ApiOperation(value = "退出登录功能借口",notes = "token不能为null")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header",name = "token",value = "用户的token",dataType = "String",required = true),
            @ApiImplicitParam(paramType = "query",name = "userId",value = "用户的Id",dataType = "int",required = true)
    })
    @GetMapping("findLogAll")
    public LogResult findLogAll(@Param("userId")int userId){
        LogResult logResult = new LogResult();
        logResult.setState(0);
        try {
            List<Log> logs = logService.findLogAll(userId);
            logResult.setState(1);
            logResult.setMsg("查看登录日志成功");
            logResult.setLogs(logs);
            logger.info("查询登录日志成");
            return logResult;
        } catch (Exception e) {
            logResult.setMsg("查询登陆日志失败："+e.getMessage());
            logger.error("查询登陆日志失败："+e.getMessage());
            return logResult;
        }
    }

}
