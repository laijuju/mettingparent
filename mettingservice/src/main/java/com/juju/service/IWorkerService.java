package com.juju.service;

import com.juju.po.Worker;

import java.util.List;

public interface IWorkerService {
    /*
        查询所有工作人员信息
     */
    List<Worker> findWorkersAll() throws Exception;

    /*
        通过ID查询工作人员信息
     */
    Worker findWorkerById(int id) throws Exception;

    /*
        增加工作人员
     */
    void addWorker(Worker worker) throws Exception;

    /*
        修改工作人员信息
     */
    void updateWorker(Worker worker) throws Exception;

    /*
        删除工作人员信息
     */
    void deleteWorker(int id) throws Exception;
}
