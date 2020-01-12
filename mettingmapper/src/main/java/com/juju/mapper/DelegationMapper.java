package com.juju.mapper;

import com.juju.po.Delegation;

import java.util.List;

public interface DelegationMapper {
    /*
        查看多有的代表团信息
     */
    List<Delegation> findDelegationAll();

    /*
        通过ID查询代表团信息
     */
    Delegation findDelegationById(int id);

    /*
        增加代表团
     */
    void addDelegation(Delegation delegation);

    /*
        修改代表团信息
     */
    void updateDelegation(Delegation delegation);

    /*
        删除代表团
     */
    void deleteDelegation(int id);
}
