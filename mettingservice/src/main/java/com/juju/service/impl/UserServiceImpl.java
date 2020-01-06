package com.juju.service.impl;

import com.juju.mapper.UserMapper;
import com.juju.po.User;
import com.juju.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public List<User> findUserByName(String username) {
        return userMapper.findUserByName(username);
    }

    @Override
    public List<User> findUserByNameAndPassword(User user) {
        return userMapper.findUserByNameAndPassword(user);
    }

    @Override
    public List<User> findUser(String username, String password) {
        return userMapper.findUser(username,password);
    }
}
