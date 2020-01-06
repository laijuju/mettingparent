package com.juju.result;

/*
    返回的一个基础的结果集数据
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResult {
    private int state;      //返回的状态码
    private String msg;     //出现错误之后的提示信息
}
