package com.juju.control;

import com.juju.mapper.UserMapper;
import com.juju.po.Admin;
import com.juju.result.AdminResult;
import com.juju.service.IAdminService;
import com.juju.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "用户功能接口测试", description = "用户功能接口测试")        //说明当前这个control接口的作用
public class UserControl {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IAdminService adminService;

    Logger logger = Logger.getLogger(UserControl.class);

    @ApiOperation(value = "查看所有用户", notes = "token不能为空")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", required = true, dataType = "String")
    @GetMapping("findUserAll")
    public AdminResult findUserAll() {
        AdminResult adminResult = new AdminResult();
        adminResult.setState(0);
        try {
            List<Admin> users = userService.findUserAll();
            adminResult.setState(1);
            adminResult.setMsg("查看所有用户成功");
            adminResult.setAdmins(users);
            logger.info("查看所有用户成功");
            return adminResult;
        } catch (Exception e) {
            adminResult.setMsg("查看所有用户失败：" + e.getMessage());
            logger.error("查看所有用户失败：" + e.getMessage());
            return adminResult;
        }
    }

    @ApiOperation(value = "通过Id查看用户", notes = "token不能为空")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", required = true, dataType = "String")
    @PostMapping("findUserById")
    public AdminResult findUserById(@RequestBody Admin admin) {
        AdminResult adminResult = new AdminResult();
        adminResult.setState(0);
        try {
            Admin user = userService.findUserById(admin.getId());
            adminResult.setState(1);
            adminResult.setMsg("通过Id查看用户成功");
            adminResult.setAdmin(user);
            logger.info("通过Id查看用户成功");
            return adminResult;
        } catch (Exception e) {
            adminResult.setMsg("通过Id查看用户失败：" + e.getMessage());
            logger.error("通过Id查看用户失败：" + e.getMessage());
            return adminResult;
        }
    }

    @ApiOperation(value = "通过userTel查看用户", notes = "token不能为空")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "userTel", value = "用户电话", required = true, dataType = "String")
    })
    @PostMapping("findUserByTel")
    public AdminResult findUserByTel(@RequestBody Admin admin) {
        AdminResult adminResult = new AdminResult();
        adminResult.setState(0);
        try {
            Admin admin1 = userService.findUserByTel(admin.getUserTel());
            adminResult.setState(1);
            adminResult.setMsg("通过userTel查看用户成功");
            adminResult.setAdmin(admin1);
            logger.info("通过userTel查看用户成功");
            return adminResult;
        } catch (Exception e) {
            logger.info("通过userTel查看用户失败：" + e.getMessage());
            adminResult.setMsg("通过userTel查看用户失败：" + e.getMessage());
            return adminResult;
        }
    }

    @ApiOperation(value = "增加用户", notes = "token不能为空")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", required = true, dataType = "String")
    @PostMapping("addUser")
    public AdminResult addUser(@RequestBody Admin admin) {
        AdminResult adminResult = new AdminResult();
        adminResult.setState(0);
        try {
            int staffId = userMapper.findStaffIdByStaffName(admin.getStaff().getStaffName());
            int delegationId = userMapper.findDelegationIdByDelName(admin.getDelegation().getDelegationName());
            admin.getStaff().setId(staffId);
            admin.getDelegation().setId(delegationId);
            userService.addUser(admin);
            adminResult.setState(1);
            adminResult.setMsg("增加用户成功");
            logger.info("增加用户成功");
            Admin admin1 = userService.findUserByTel(admin.getUserTel());
            adminService.addUserRole(admin1.getId(),3);
            return adminResult;
        } catch (Exception e) {
            logger.error("增加用户失败：" + e.getMessage());
            adminResult.setMsg("增加用户失败：" + e.getMessage());
            return adminResult;
        }
    }

    @ApiOperation(value = "修改用户信息", notes = "token不能为空")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", required = true, dataType = "String")
    @PostMapping("updateUser")
    public AdminResult updateUser(@RequestBody Admin admin) {
        AdminResult adminResult = new AdminResult();
        adminResult.setState(0);
        try {
            int staffId = userMapper.findStaffIdByStaffName(admin.getStaff().getStaffName());
            int delegationId = userMapper.findDelegationIdByDelName(admin.getDelegation().getDelegationName());
            admin.getStaff().setId(staffId);
            admin.getDelegation().setId(delegationId);
            userService.updateUser(admin);
            adminResult.setState(1);
            adminResult.setMsg("修改用户信息成功");
            logger.info("修改用户信息成功");
            return adminResult;
        } catch (Exception e) {
            adminResult.setMsg("修改用户信息失败：" + e.getMessage());
            logger.error("修改用户信息失败：" + e.getMessage());
            return adminResult;
        }
    }

}
