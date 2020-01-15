package com.juju.po;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    权限表
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class Perm {
    private int id;             //权限ID
    private int roleId;         //角色ID
    private String permName;    //权限的名字
    private String permDes;     //权限的描述
    private String type;        //类型  值：perm(表示的是权限)  res(资源)
    private String resName;     //资源的名字
    private String resPath;     //资源的请求地址
}
