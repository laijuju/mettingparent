package com.juju.po;

/*
    角色实体
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private int id;                 //ID字段
    private String roleName;        //角色名字
    private String roleDes;         //角色描述
    private List<Perm> perms;       //角色具有权限
}
