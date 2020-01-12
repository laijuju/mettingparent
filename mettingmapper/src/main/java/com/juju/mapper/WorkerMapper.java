package com.juju.mapper;

import com.juju.po.Worker;

import java.util.List;

public interface WorkerMapper {
    /*
        查询所有工作人员信息
     */
    List<Worker> findWorkersAll();

    /*
        通过ID查询工作人员信息
     */
    Worker findWorkerById(int id);

    /*
        增加工作人员
     */
    void addWorker(Worker worker);

    /*
        修改工作人员信息
     */
    void updateWorker(Worker worker);

    /*
        删除工作人员信息
     */
    void deleteWorker(int id);
}
