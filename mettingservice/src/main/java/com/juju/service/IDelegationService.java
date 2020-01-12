package com.juju.service;

import com.juju.po.Delegation;

import java.util.List;

public interface IDelegationService {
    /*
        查看多有的代表团信息
     */
    List<Delegation> findDelegationAll() throws Exception;

    /*
        通过ID查询代表团信息
     */
    Delegation findDelegationById(int id) throws Exception;

    /*
        增加代表团
     */
    void addDelegation(Delegation delegation) throws Exception;

    /*
        修改代表团信息
     */
    void updateDelegation(Delegation delegation) throws Exception;

    /*
        删除代表团
     */
    void deleteDelegation(int id) throws Exception;
}
