package cn.zx.mapper;

import java.util.List;

import cn.zx.pojo.User;

public interface UserMapper {
    public void add(User user);
    public void remove(String username);
    public User find(String username);
    public void update(User user);


}
