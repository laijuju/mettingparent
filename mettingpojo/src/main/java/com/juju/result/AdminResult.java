package com.juju.result;

import com.juju.po.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminResult extends  BaseResult {
    private Admin admin;
    private List<Admin> admins;
}
