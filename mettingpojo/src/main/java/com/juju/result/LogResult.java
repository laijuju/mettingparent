package com.juju.result;

import com.juju.po.Log;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogResult extends BaseResult {
    private List<Log> logs;
    private Log log;
}
