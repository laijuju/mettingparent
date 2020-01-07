package com.juju.result;

import com.juju.po.Perm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermResult extends BaseResult {
    private Perm perm;
    private List<Perm> perms;
}
