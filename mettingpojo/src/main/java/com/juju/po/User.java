package com.juju.po;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "用户的对象模型")
public class User {

//    @ApiModelProperty(name = "username",value = "用户名",required = true)
    private  String username;
//    @ApiModelProperty(name = "password",value = "用户密码",required = true)
    private  String password;

}
