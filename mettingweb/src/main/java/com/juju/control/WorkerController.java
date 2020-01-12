package com.juju.control;

import com.juju.po.Worker;
import com.juju.result.WorkerResult;
import com.juju.service.IWorkerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Api(value = "会议秘书功能测试接口",description = "会议秘书功能测试接口")
public class WorkerController {

    Logger logger = Logger.getLogger(WorkerController.class);

    @Autowired
    private IWorkerService workerService;

    @ApiOperation(value = "查看所有工作人员信息")
    @ApiImplicitParam(paramType = "header",name = "token",value = "用户token",dataType = "String",required = true)
    @GetMapping("findWorkersAll")
    public WorkerResult findWorkersAll(){
        WorkerResult workerResult = new WorkerResult();
        workerResult.setState(0);
        try {
            List<Worker> workers = workerService.findWorkersAll();
            workerResult.setState(1);
            workerResult.setMsg("查询所有工作人员信息成功");
            workerResult.setWorkers(workers);
            logger.info("查询所有工作人员信息成功");
            return workerResult;
        } catch (Exception e) {
            workerResult.setMsg("查询所有工作人员信息失败:"+e.getMessage());
            logger.error("查询所有工作人员信息失败:"+e.getMessage());
            return workerResult;
        }
    }

    @ApiOperation(value = "通过ID查看工作人员信息")
    @ApiImplicitParam(paramType = "header",name = "token",value = "用户token",dataType = "String",required = true)
    @PostMapping("findWorkerById")
    public WorkerResult findWorkerById(@RequestBody Worker worker){
        WorkerResult workerResult = new WorkerResult();
        workerResult.setState(0);
        try {
            Worker worker1 = workerService.findWorkerById(worker.getId());
            workerResult.setState(1);
            workerResult.setMsg("通过ID查询工作人员信息成功");
            logger.info("通过ID查询工作人员信息成功");
            workerResult.setWorker(worker1);
            return workerResult;
        } catch (Exception e) {
            workerResult.setMsg("通过ID查询工作人员信息失败："+e.getMessage());
            logger.error("通过ID查询工作人员信息失败："+e.getMessage());
            return workerResult;
        }
    }

    @ApiOperation(value = "修改工作人员信息")
    @ApiImplicitParam(paramType = "header",name = "token",value = "用户token",dataType = "String",required = true)
    @PostMapping("updateWorker")
    public WorkerResult updateWorker(@RequestBody Worker worker){
        WorkerResult workerResult = new WorkerResult();
        workerResult.setState(0);
        try {
            workerService.updateWorker(worker);
            workerResult.setState(1);
            workerResult.setMsg("修改工作人员信息成功");
            logger.info("修改工作人员信息");
            return workerResult;
        } catch (Exception e) {
            logger.error("修改工作人员失败："+e.getMessage());
            workerResult.setMsg("修改工作人员信息失败："+e.getMessage());
            return workerResult;
        }
    }

    @ApiOperation(value = "删除工作人员信息")
    @ApiImplicitParam(paramType = "header",name = "token",value = "用户token",dataType = "String",required = true)
    @PostMapping("deleteWorker")
    public WorkerResult deleteWorker(@RequestBody Worker worker){
        WorkerResult workerResult = new WorkerResult();
        workerResult.setState(0);
        try {
            workerService.deleteWorker(worker.getId());
            workerResult.setState(1);
            workerResult.setMsg("删除工作人员成功");
            logger.info("删除工作人员成功");
            return workerResult;
        } catch (Exception e) {
            workerResult.setMsg("删除工作人员失败："+e.getMessage());
            logger.error("删除工作人员失败："+e.getMessage());
            return workerResult;
        }
    }

    @ApiOperation(value = "增加工作人员信息")
    @ApiImplicitParam(paramType = "header",name = "token",value = "用户token",dataType = "String",required = true)
    @PostMapping("addWorker")
    public WorkerResult addWorker(@RequestBody Worker worker){
        WorkerResult workerResult = new WorkerResult();
        workerResult.setState(0);
        try {
            workerService.addWorker(worker);
            workerResult.setState(1);
            workerResult.setMsg("增加工作人员信息成功");
            logger.info("增加工作人员信息成功");
            return workerResult;
        } catch (Exception e) {
            workerResult.setMsg("增加工作人员信息失败："+e.getMessage());
            logger.error("增加工作人员信息失败："+e.getMessage());
            return workerResult;
        }
    }
}
