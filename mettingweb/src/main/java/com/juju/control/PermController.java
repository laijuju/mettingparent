package com.juju.control;

import com.juju.po.Perm;
import com.juju.result.PermResult;
import com.juju.service.IPermService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
    权限的控制类
 */
@RestController
@Api(value = "权限的控制器",description = "权限的控制器测试接口")
public class PermController {

    private Logger logger = Logger.getLogger(PermController.class);

    @Autowired
    private IPermService permService;

    @PostMapping(value = "addPerm")
    @ApiOperation(value = "添加权限",notes = "权限对象不能为空")
    @ApiImplicitParam(paramType = "header",name = "token",value = "用户token",dataType = "String",required = true)
    public PermResult addPerm(@RequestBody Perm perm){
        PermResult permResult = new PermResult();
        permResult.setState(0);
        try {
            permService.addPerm(perm);
            permResult.setState(1);
            permResult.setMsg("添加权限成功");
            logger.info("添加权限成功");
            return permResult;
        } catch (Exception e) {
            permResult.setMsg("添加权限失败："+e.getMessage());
            logger.error("添加权限失败："+e.getMessage());
            return permResult;
        }
    }

    @PostMapping("findPermByRoleId")
    @ApiOperation(value = "通过角色ID查询角色的权限")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header",name = "token",value = "用户的token",dataType = "String",required = true),
            @ApiImplicitParam(paramType = "query",name = "roleId",value = "角色Id",dataType = "int",required = true)
    })
    public PermResult findPermByRoleId(int roleId){
        PermResult permResult = new PermResult();
        permResult.setState(0);
        try {
            List<Perm> perms = permService.findPermByRoleId(roleId);
            permResult.setState(1);
            permResult.setPerms(perms);
            permResult.setMsg("通过角色ID查询权限成功");
            logger.info("通过角色ID查询权限成功");
            return permResult;
        } catch (Exception e) {
            permResult.setMsg("通过角色ID查询权限失败："+e.getMessage());
            logger.error("通过角色ID查询权限失败"+e.getMessage());
            return permResult;
        }
    }

    @PostMapping("findPermsAll")
    @ApiOperation(value = "查看所有的权限")
    @ApiImplicitParam(paramType = "header",value = "用户token",name = "token",dataType = "String",required = true)
    public PermResult findPermsAll(){
        PermResult permResult = new PermResult();
        permResult.setState(0);
        try {
            List<Perm> perms = permService.findPermsAll();
            permResult.setState(1);
            permResult.setMsg("查看所有权限成功");
            permResult.setPerms(perms);
            logger.info("查看所有权限成功");
            return permResult;
        } catch (Exception e) {
            permResult.setMsg("查看所有权限失败："+e.getMessage());
            logger.error("查看所有权限失败："+e.getMessage());
            return permResult;
        }
    }

    @PostMapping("deletePerm")
    @ApiOperation(value = "通过ID删除权限")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header",value = "用户token",name = "token",dataType = "String",required = true),
            @ApiImplicitParam(paramType = "query",value = "权限id",name = "permId",dataType = "int",required = true)
    })
    public PermResult deletePermById(int permId){
        PermResult permResult = new PermResult();
        permResult.setState(0);
        try {
            permService.deletePermById(permId);
            permResult.setState(1);
            permResult.setMsg("删除权限成功");
            logger.info("删除权限成功");
            return permResult;
        } catch (Exception e) {
            permResult.setMsg("删除权限失败："+e.getMessage());
            logger.error("删除权限失败："+e.getMessage());
            return permResult;
        }
    }


}
