package com.juju.control;

import com.juju.po.User;
import com.juju.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Api(value = "用户接口")        //说明当前这个control接口的作用
public class UserControl {

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("insertUser")
    public Object insertUser(User user){
        userService.insertUser(user);
        System.out.println("成功");
        return "成功";
    }

    @ResponseBody
    @PostMapping("findAllUser")
    //用于说明方法
    @ApiOperation(value = "查找所有对象",notes = "不用传递对象")
    public List<User> findAllUser(){

        return userService.findAllUser();
    }

    @PostMapping("findUserByName")
    @ApiOperation(value = "通过用户名查询用户",notes = "用户名不能为空")
    @ApiImplicitParam(paramType = "query",name = "username",value = "用户名",required = true,dataType = "String")
    public List<User> findUserByName(@RequestParam("username") String username)
    {
        return userService.findUserByName(username);
    }

    @PostMapping("findUserByNameAndPassword")
    @ApiOperation(value = "通过用户查找用户",notes = "都不能为空")
    public List<User> findUserByNameAndPassword(@RequestBody User user){
        return userService.findUserByNameAndPassword(user);
    }

    @PostMapping("findUser")
    @ApiOperation(value = "通过用户名和密码查找用户",notes = "都不能为空")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "密码", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "header",name = "token",value = "用户token",required = true,dataType = "String")
    })
    public List<User> findUser(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               HttpServletRequest request){
        String token = request.getHeader("token");
        System.out.println("前端传值过来的token："+token);
        return userService.findUser(username,password);
    }


}
