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
    private int userId;             //用户主键
    private Date loginTime;    //登录时间
}
