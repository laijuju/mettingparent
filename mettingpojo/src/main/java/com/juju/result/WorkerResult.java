package com.juju.result;

import com.juju.po.Worker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkerResult extends BaseResult {

    private List<Worker> workers;
    private Worker worker;
}
