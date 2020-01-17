package com.juju.result;

import com.juju.po.ActionLog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActionLogResult extends BaseResult {
    private List<ActionLog> actionLogs;
    private ActionLog actionLog;
}
