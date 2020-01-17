package com.juju.control;

import com.juju.po.ActionLog;
import com.juju.result.ActionLogResult;
import com.juju.service.IActionLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "行为日志功能接口测试", description = "行为日志功能接口测试")
public class ActionLogController {

    @Autowired
    private IActionLogService actionLogService;

    Logger logger = Logger.getLogger(ActionLogController.class);

    @ApiOperation(value = "查询用户的行为日志", notes = "token不能为null")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户的token", dataType = "String", required = true)

    @GetMapping("findActionAll")
    public ActionLogResult findActionAll(@RequestParam("adminLoginName") String adminLoginName) {
        ActionLogResult actionLogResult = new ActionLogResult();
        actionLogResult.setState(0);
        try {
            List<ActionLog> actions = actionLogService.findActionAll(adminLoginName);
            actionLogResult.setState(1);
            actionLogResult.setMsg("查询用户的行为日志");
            actionLogResult.setActionLogs(actions);
            return actionLogResult;
        } catch (Exception e) {
            actionLogResult.setMsg("查询用户的行为日志失败：" + e.getMessage());
            return actionLogResult;
        }
    }

    @ApiOperation(value = "添加用户的行为日志", notes = "token不能为null")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户的token", dataType = "String", required = true)
    @PostMapping("addActionLog")
    public ActionLogResult addActionLog(@RequestBody ActionLog actionLog) {
        ActionLogResult actionLogResult = new ActionLogResult();
        actionLogResult.setState(0);
        try {
            actionLogService.addActionLog(actionLog);
            actionLogResult.setState(1);
            actionLogResult.setMsg("添加用户的行为日志成功");
            return actionLogResult;
        } catch (Exception e) {
            actionLogResult.setMsg("添加用户的行为日志失败：" + e.getMessage());
            return actionLogResult;
        }
    }

}
