package cn.itcast.service;

import cn.itcast.domain.User;

public interface UserService {
    public User findByUsername(String username);
    public void createUser(User user);
}
