package com.juju.control;

import com.juju.po.Perm;
import com.juju.po.Role;
import com.juju.result.RoleResult;
import com.juju.service.IPermService;
import com.juju.service.IRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value = "角色的控制器",description = "角色控制器测试接口")
public class RoleController {

    @Autowired
    private IRoleService roleService;
    @Autowired
    private  IPermService permService;

    private Logger logger = Logger.getLogger(RoleController.class);

    /*
        添加一个角色
     */
    @PostMapping("addRole")
    @ApiOperation(value = "添加一个角色",notes = "token不能为空")
    @ApiImplicitParam(paramType = "header",value = "用户token",name = "token",dataType = "String",required = true)
    public RoleResult addRole(@RequestBody Role role){
        RoleResult roleResult = new RoleResult();
        roleResult.setState(0);
        try {
            roleService.addRole(role);
            roleResult.setState(1);
            roleResult.setMsg("添加角色成功");
            logger.info("添加角色成功！");
            return roleResult;
        } catch (Exception e) {
            logger.info("添加角色失败");
            roleResult.setMsg("添加角色失败："+e.getMessage());
            return roleResult;
        }
    }

    /*
        查看所有角色
     */
    @PostMapping("findRoleAll")
    @ApiOperation(value = "查看所有的角色")
    @ApiImplicitParam(paramType = "header",name = "token",value = "用户的token",dataType = "String",required = true)
    public RoleResult findRoleAll(){
        RoleResult roleResult = new RoleResult();
        roleResult.setState(0);
        try {
            List<Role> roleAll = roleService.findRoleAll();
            roleResult.setRoles(roleAll);
            roleResult.setState(1);
            roleResult.setMsg("查询成功");
            logger.info("查看所有角色成功");
            return roleResult;
        } catch (Exception e) {
            roleResult.setMsg("查询所有角色失败："+e.getMessage());
            logger.error("查看所有角色失败："+e.getMessage());
            return roleResult;
        }
    }

    /*
        通过roleId查询role
     */
    @PostMapping("findRoleById")
    @ApiOperation(value = "通过Id查询角色")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header",name = "token",value = "用户token",dataType = "String",required = true),
            @ApiImplicitParam(paramType = "query",name = "roleId",value = "角色ID",dataType = "int",required = true)
    })
    public RoleResult findRoleById(int roleId){
        RoleResult roleResult = new RoleResult();
        roleResult.setState(0);
        try {
            Role role = roleService.findRoleById(roleId);
            roleResult.setState(1);
            roleResult.setMsg("通过Id查询角色成功");
            roleResult.setRole(role);
            logger.info("通过Id查询角色成功");
            return roleResult;
        } catch (Exception e) {
            roleResult.setMsg("通过Id查询角色失败："+e.getMessage());
            logger.error("通过Id查询角色失败："+e.getMessage());
            return roleResult;
        }
    }

    @PostMapping("deleteRole")
    @ApiOperation(value = "通过Id删除角色")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header",name = "token",value = "用户token",dataType = "String",required = true),
            @ApiImplicitParam(paramType = "query",name = "roleId",value = "角色Id",dataType = "int",required = true)
    })
    public RoleResult deleteRole(int roleId){
        RoleResult roleResult = new RoleResult();
        roleResult.setState(0);
        try {
            roleService.deleteRole(roleId);
            roleResult.setState(1);
            roleResult.setMsg("通过Id删除角色成功");
            logger.info("通过Id删除角色成功");
            return roleResult;
        } catch (Exception e) {
            roleResult.setMsg("通过Id删除角色失败："+e.getMessage());
            logger.error("通过Id删除角色失败！"+e.getMessage());
            return roleResult;
        }
    }

    @PostMapping("findRoleByAdminId")
    @ApiOperation(value = "通过管理员Id查看角色")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header",name = "token",value = "用户token",dataType = "String",required = true),
            @ApiImplicitParam(paramType = "query",name = "adminId",value = "管理员Id",dataType = "int",required = true)
    })
    public RoleResult findRoleByAdminId(int adminId){
        RoleResult roleResult = new RoleResult();
        roleResult.setState(0);
        try {
            List<Role> roles = roleService.findRoleByAdminId(adminId);
            roleResult.setState(1);
            roleResult.setMsg("通过管理员ID查询角色成功");
            roleResult.setRoles(roles);
            logger.info("通过管理员ID查询角色成功");
            return roleResult;
        } catch (Exception e) {
            roleResult.setMsg("通过管理员ID查询角色失败："+e.getMessage());
            logger.error("通过管理员ID查询角色成功"+e.getMessage());
            return roleResult;
        }
    }

    @PostMapping("updateRoleById")
    @ApiOperation(value = "通过ID修改角色信息")
    @ApiImplicitParam(paramType = "header",name = "token",value = "用户token",dataType = "String",required = true)
    public RoleResult updateRoleById(@RequestBody Role role){
        RoleResult roleResult = new RoleResult();
        roleResult.setState(0);
        try {
            roleService.updateRoleById(role);
            roleResult.setState(1);
            roleResult.setMsg("通过ID修改角色信息成功");
            logger.info("通过ID修改角色信息成功");
            return roleResult;
        } catch (Exception e) {
            logger.error("通过ID修改角色信息失败："+e.getMessage());
            roleResult.setMsg("通过ID修改角色信息失败："+e.getMessage());
            return roleResult;
        }
    }

    @ApiOperation(value = "通过角色ID修改角色权限")
    @ApiImplicitParam(paramType = "header",name = "token",value = "用户token",dataType = "String",required = true)
    @PostMapping("addPermsByRoleId")
    public RoleResult addPermsByRoleId(@RequestBody  Role role){
        RoleResult roleResult = new RoleResult();
        roleResult.setState(0);
        try {
            List<Perm> perms = new ArrayList<>();
            String permsString = role.getPermsString();
            String[] permNames = permsString.split(",");
            for (String permName:permNames) {
                Perm perm = new Perm();
                perm.setId(permService.findPermIdByPermName(permName));
                perms.add(perm);
            }
            System.out.println("添加完成的perms："+perms);
            role.setPerms(perms);
            roleService.deleteAllPermsByRoleId(role.getRoleId());
            roleService.addPermsByRoleId(role);
            roleResult.setState(1);
            roleResult.setMsg("通过角色ID修改角色权限成功");
            logger.info("通过角色ID修改角色权限成功");
            return roleResult;
        } catch (Exception e) {
            roleResult.setMsg("通过角色ID修改角色权限失败："+e.getMessage());
            logger.error("通过角色ID修改角色权限失败："+e.getMessage());
            return roleResult;
        }
    }
}
