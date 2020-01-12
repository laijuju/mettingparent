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
    private int id;
    private String workerName;
    private String workerTel;
    private int workerSex;
}
