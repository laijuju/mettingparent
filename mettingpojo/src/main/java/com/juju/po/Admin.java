package com.juju.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
    管理员表
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "管理员实体")
public class Admin {
    private int id;     //用户Id
    @ApiModelProperty(value = "管理员昵称",required = false)
    private String adminNickName;       //管理员名字
    @ApiModelProperty(value = "管理员账号",required = false)
    private String adminLoginName;      //管理员登录账户
    @ApiModelProperty(value = "管理员密码",required = false)
    private String adminPassword;       //管理员登录密码
    @ApiModelProperty(value = "管理员性别",required = false)
    private int adminSex;               //性别： 0：男  1：女  2：其他
    @ApiModelProperty(value = "管理员电话",required = false)
    private String adminTel;            //管理员的电话号码
    private List<Role> roles;           //用户的角色
    private List<Perm> perms;           //用户的权限
    @ApiModelProperty(value = "管理员token",required = false)
    private String token;               //管理员的token
    private long expireTokenTime;       //token过期时间

    private String userTel;             //用户的电话号码
    private String staffId;             //职位ID
    private String delegationId;        //代表团ID

}
