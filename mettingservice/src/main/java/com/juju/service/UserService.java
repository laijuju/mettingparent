package com.juju.service;

import com.juju.po.User;

import java.util.List;

public interface UserService {
    public void insertUser(User user);

    public List<User> findAllUser();

    public List<User> findUserByName(String username);

    public List<User> findUserByNameAndPassword(User user);

    public List<User> findUser(String username,String password);
}
