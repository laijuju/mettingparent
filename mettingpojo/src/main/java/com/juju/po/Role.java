package com.juju.po;

/*
    角色实体
 */

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "角色的实体")
public class Role {
    private int roleId;             //ID字段
    private String roleName;        //角色名字
    private String roleDes;         //角色描述
    private List<Perm> perms;       //角色具有权限
    private String permsString;
}
