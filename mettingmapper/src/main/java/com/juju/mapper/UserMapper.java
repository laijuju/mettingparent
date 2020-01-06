package com.juju.mapper;

import com.juju.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    public void insertUser(User user);

    public List<User> findAllUser();

    public List<User> findUserByName(String username);

    public List<User> findUserByNameAndPassword(User user);

    public List<User> findUser(@Param("username") String username, @Param("password") String password);
}
