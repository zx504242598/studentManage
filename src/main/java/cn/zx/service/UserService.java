package cn.zx.service;

import java.util.List;

import cn.zx.pojo.User;

/**
 * @program: ssm
 * @description:
 * @author: liust
 * @create: 2018-10-16 19:42
 **/
public interface UserService {
    public void add(User user);
    public void remove(String username);
    public User find(String username);
    public void update(User user);
}
