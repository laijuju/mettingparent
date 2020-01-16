package com.juju.po;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class Log {
    private int id;                 //日志主键
    private String nickName;        //用户名
    private String loginName;       //用户账号
    private Date loginTime;         //登录时间
    private String loginState;      //登录状态
}
