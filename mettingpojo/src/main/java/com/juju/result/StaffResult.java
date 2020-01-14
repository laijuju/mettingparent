package com.juju.result;

import com.juju.po.Staff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffResult extends BaseResult {
    private List<Staff> staffs;
    private Staff staff;
}
