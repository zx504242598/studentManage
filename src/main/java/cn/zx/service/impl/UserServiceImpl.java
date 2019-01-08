package cn.zx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import cn.zx.mapper.UserMapper;
import cn.zx.pojo.User;
import cn.zx.service.UserService;

/**
 * @program: ssm
 * @description:
 * @author: liust
 * @create: 2018-10-16 19:43
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    public void add(User user) {
        userMapper.add(user);
    }

    public void remove(String username) {
        userMapper.remove(username);
    }

    public User find(String username) {
        return userMapper.find(username);
    }

    public void update(User user) {
        userMapper.update(user);
    }

}
