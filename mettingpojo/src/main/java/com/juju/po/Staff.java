package com.juju.po;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class Staff {
    private int id;                 //职位Id
    private String staffName;       //职位
    private String staffDes;        //职位描述
}
