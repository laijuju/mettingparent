package com.juju.result;

import com.juju.po.Delegation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DelegationResult extends BaseResult {
    private List<Delegation> delegations;
    private Delegation delegation;
}
