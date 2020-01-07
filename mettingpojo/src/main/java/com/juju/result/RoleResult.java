package com.juju.result;

import com.juju.po.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResult extends BaseResult {
    private Role role;
    private List<Role> roles;
}
