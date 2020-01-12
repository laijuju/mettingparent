package com.juju.service.impl;

import com.juju.mapper.UserMapper;
import com.juju.po.Admin;
import com.juju.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(Admin admin) throws Exception {
        userMapper.addUser(admin);
    }

    @Override
    public List<Admin> findUserAll() throws Exception {
        return userMapper.findUserAll();
    }

    @Override
    public Admin findUserById(int id) throws Exception {
        return userMapper.findUserById(id);
    }

    @Override
    public Admin findUserByTel(String userTel) throws Exception {
        return userMapper.findUserByTel(userTel);
    }

    @Override
    public void updateUser(Admin admin) throws Exception {
        userMapper.updateUser(admin);
    }

    @Override
    public void deleteUser(int id) throws Exception {
        userMapper.deleteUser(id);
    }
}
