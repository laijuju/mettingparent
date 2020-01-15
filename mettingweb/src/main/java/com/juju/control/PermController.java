package com.juju.control;

import com.juju.po.Perm;
import com.juju.po.Role;
import com.juju.result.PermResult;
import com.juju.result.RoleResult;
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
    public RoleResult findPermByRoleId(int roleId){
        RoleResult roleResult = new RoleResult();
        roleResult.setState(0);
        try {
            Role role = permService.findPermByRoleId(roleId);
            roleResult.setState(1);
            roleResult.setRole(role);
            roleResult.setMsg("通过角色ID查询权限成功");
            logger.info("通过角色ID查询权限成功");
            return roleResult;
        } catch (Exception e) {
            roleResult.setMsg("通过角色ID查询权限失败："+e.getMessage());
            logger.error("通过角色ID查询权限失败"+e.getMessage());
            return roleResult;
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

    @PostMapping("updatePerm")
    @ApiOperation(value = "通过Id修改权限")
    @ApiImplicitParam(paramType = "header",required = true,dataType = "String",name = "token",value = "用户token")
    public PermResult updatePerm(@RequestBody Perm perm){
        System.out.println("接受到的值："+perm);
        PermResult permResult = new PermResult();
        permResult.setState(0);
        try {
            permService.updatePerm(perm);
            permResult.setState(1);
            permResult.setMsg("修改权限成功");
            logger.info("修改权限成功");
            return permResult;
        } catch (Exception e) {
            permResult.setMsg("修改权限失败："+e.getMessage());
            logger.error("修改权限失败："+e.getMessage());
            return permResult;
        }
    }

    @PostMapping("findPermByPermId")
    @ApiOperation(value = "通过权限的Id查看权限")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header",name = "token",value = "用户token",dataType = "String",required = true),
            @ApiImplicitParam(paramType = "query",name = "permId",value = "权限ID",dataType = "int",required = true)
    })
    public PermResult findPermByPermId(int permId){
        PermResult permResult = new PermResult();
        permResult.setState(0);
        try {
            Perm perm = permService.findPermByPermId(permId);
            permResult.setState(1);
            permResult.setMsg("通过ID查找权限成功");
            permResult.setPerm(perm);
            logger.info("通过ID查找权限成功");
            return permResult;
        } catch (Exception e) {
            logger.error("通过ID查找权限失败："+e.getMessage());
            permResult.setMsg("通过ID查找权限失败："+e.getMessage());
            return permResult;
        }
    }


}
