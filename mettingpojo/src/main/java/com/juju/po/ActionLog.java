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
public class ActionLog {
    private int id;                     //行为操作表ID
    private String nickName;            //用户
    private String adminLoginName;      //账户
    private String actionName;          //操作
    private Date actionTime;            //操作时间
    private String actionState;         //状态
}
