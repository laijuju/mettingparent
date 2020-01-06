package com.juju.control;

import com.juju.po.Admin;
import com.juju.result.AdminResult;
import com.juju.service.IAdminService;
import com.juju.utils.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(value = "管理员的接口")
public class AdminController {

    private Logger logger = Logger.getLogger(AdminController.class);

    @Autowired
    private IAdminService adminService;

    /*
        管理员的添加
     */
    @PostMapping("addAdmin")
    @ApiOperation(value = "添加管理员",notes = "管理员对象不能为空")
    @ApiImplicitParam(paramType = "header",name = "token",value = "用户token",required = true,dataType = "String")
    public AdminResult add(@RequestBody Admin admin){
        AdminResult adminResult = new AdminResult();
        adminResult.setState(0);     //默认添加不成功
        try {
            System.out.println("进入addAdmin方法");
            String password = admin.getAdminPassword();
            password = MD5Util.encrypt(password);
            admin.setAdminPassword(password);
            adminService.addAdmin(admin);
            //添加成功
            adminResult.setState(1);
        } catch (Exception e) {
            //说明添加失败
            adminResult.setMsg("添加用户失败"+e.getMessage());
        }
        return adminResult;
    }

    /*
        用户的登录
     */
    @PostMapping("login")
    @ApiOperation(value = "用户登录",notes = "用户名和密码不能为null")
    public AdminResult login(@RequestBody  Admin admin){
           return adminService.login(admin);
    }
    /*
        登录退出
     */
    @PostMapping("logout")
    @ApiOperation(value = "退出登录功能借口",notes = "token不能为null")
    @ApiImplicitParam(paramType = "header",name = "token",value = "用户的token",dataType = "String",required = true)
    public AdminResult logout(HttpServletRequest request){
        String token = request.getHeader("token");
        AdminResult adminResult = new AdminResult();
        adminResult.setState(0);
        try {
            adminService.logout(token);
            adminResult.setState(1);
            adminResult.setMsg("退出账户成功");
        } catch (Exception e) {
            adminResult.setMsg("退出账户失败："+e);
        }
        return adminResult;
    }

}
