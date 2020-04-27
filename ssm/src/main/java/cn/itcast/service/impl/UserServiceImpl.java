package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User findByUsername(String username) {
        User user=userDao.findByUsername(username);
        return user;
    }

    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

}
