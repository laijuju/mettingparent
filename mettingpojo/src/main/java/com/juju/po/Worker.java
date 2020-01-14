package com.juju.po;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class Worker {
    private int id;                 //工作人员ID
    private String workerName;      //工作人员姓名
    private String workerTel;       //工作人员电话
    private int workerSex;          //工作人员性别
}
