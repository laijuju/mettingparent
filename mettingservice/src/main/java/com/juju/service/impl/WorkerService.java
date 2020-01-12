package com.juju.service.impl;

import com.juju.mapper.WorkerMapper;
import com.juju.po.Worker;
import com.juju.service.IWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WorkerService implements IWorkerService {

    @Autowired
    private WorkerMapper workerMapper;

    @Override
    public List<Worker> findWorkersAll() throws Exception {
        return workerMapper.findWorkersAll();
    }

    @Override
    public Worker findWorkerById(int id) throws Exception {
        return workerMapper.findWorkerById(id);
    }

    @Override
    public void addWorker(Worker worker) throws Exception {
        workerMapper.addWorker(worker);
    }

    @Override
    public void updateWorker(Worker worker) throws Exception {
        workerMapper.updateWorker(worker);
    }

    @Override
    public void deleteWorker(int id) throws Exception {
        workerMapper.deleteWorker(id);
    }
}
