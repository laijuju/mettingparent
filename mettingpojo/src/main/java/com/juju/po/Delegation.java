package com.juju.po;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class Delegation {
    private int id;                     //代表团ID
    private String delegationName;      //代表团名字
    private String delegationDetails;   //代表团描述
}
