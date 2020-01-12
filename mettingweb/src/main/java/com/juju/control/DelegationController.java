package com.juju.control;

import com.juju.po.Delegation;
import com.juju.result.DelegationResult;
import com.juju.service.IDelegationService;
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
@Api(value = "代表团功能接口测试",description = "代表团功能接口测试")
public class DelegationController {

    Logger logger = Logger.getLogger(DelegationController.class);

    @Autowired
    private IDelegationService delegationService;

    @ApiOperation(value = "查询所以代表团信息")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true)
    @GetMapping("findDelegationAll")
    public DelegationResult findDelegationAll(){
        DelegationResult delegationResult = new DelegationResult();
        delegationResult.setState(0);
        try {
            List<Delegation> delegations = delegationService.findDelegationAll();
            delegationResult.setState(1);
            delegationResult.setMsg("查询所以代表团信息成功");
            delegationResult.setDelegations(delegations);
            logger.info("查询所以代表团信息成功");
            return  delegationResult;
        } catch (Exception e) {
            logger.error("查询所以代表团信息失败："+e.getMessage());
            delegationResult.setMsg("查询所以代表团信息失败"+e.getMessage());
            return delegationResult;
        }
    }

    @ApiOperation(value = "通过ID查询代表团信息")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true)
    @PostMapping("findDelegationById")
    public DelegationResult findDelegationById(@RequestBody Delegation delegation){
        DelegationResult delegationResult = new DelegationResult();
        delegationResult.setState(0);
        try {
            Delegation delegation1 = delegationService.findDelegationById(delegation.getId());
            delegationResult.setState(1);
            delegationResult.setMsg("通过ID查询代表团信息成功");
            delegationResult.setDelegation(delegation1);
            logger.info("通过ID查询代表团信息成功");
            return delegationResult;
        } catch (Exception e) {
            delegationResult.setMsg("通过ID查询代表团信息失败："+e.getMessage());
            logger.error("通过ID查询代表团信息失败："+e.getMessage());
            return delegationResult;
        }
    }

    @ApiOperation(value = "增加代表团信息")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true)
    @PostMapping("addDelegation")
    public DelegationResult addDelegation(@RequestBody Delegation delegation){
        DelegationResult delegationResult = new DelegationResult();
        delegationResult.setState(0);
        try {
            delegationService.addDelegation(delegation);
            delegationResult.setState(1);
            delegationResult.setMsg("增加代表团信息成功");
            logger.info("增加代表团信息");
            return delegationResult;
        } catch (Exception e) {
            delegationResult.setMsg("增加代表团信息失败："+e.getMessage());
            logger.error("增加代表团信息失败："+e.getMessage());
            return delegationResult;
        }
    }

    @ApiOperation(value = "修改代表团信息")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true)
    @PostMapping("updateDelegation")
    public DelegationResult updateDelegation(@RequestBody  Delegation delegation){
        DelegationResult delegationResult = new DelegationResult();
        delegationResult.setState(0);
        try {
            delegationService.updateDelegation(delegation);
            delegationResult.setState(1);
            delegationResult.setMsg("修改代表团信息成功");
            logger.info("修改代表团信息成功");
            return delegationResult;
        } catch (Exception e) {
            delegationResult.setMsg("修改代表团信息失败："+e.getMessage());
            logger.error("修改代表团信息失败："+e.getMessage());
            return delegationResult;
        }
    }

    @ApiOperation(value = "删除代表团信息")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true)
    @PostMapping("deleteDelegation")
    public DelegationResult deleteDelegation(@RequestBody Delegation delegation){
        DelegationResult delegationResult = new DelegationResult();
        delegationResult.setState(0);
        try {
            delegationService.deleteDelegation(delegation.getId());
            delegationResult.setState(1);
            delegationResult.setMsg("删除代表团信息成功");
            logger.info("删除代表团信息成功");
            return delegationResult;
        } catch (Exception e) {
            logger.error("删除代表团信息失败："+e.getMessage());
            delegationResult.setMsg("删除代表团信息失败："+e.getMessage());
            return delegationResult;
        }
    }
}
