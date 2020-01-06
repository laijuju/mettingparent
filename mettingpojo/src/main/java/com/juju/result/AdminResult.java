package com.juju.result;

import com.juju.po.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminResult extends  BaseResult {
    private Admin admin;
}
