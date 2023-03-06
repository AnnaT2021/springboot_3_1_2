package com.test_springboot.springboot_3_1_2.service;

import com.test_springboot.springboot_3_1_2.dao.UserDao;
import com.test_springboot.springboot_3_1_2.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void add(User user){
        this.userDao.add(user);
    }
    @Override
    @Transactional
    public void update(int id, User user) {
        this.userDao.update(id, user);
    }
    @Override
    @Transactional
    public void delete(int id){
        this.userDao.delete(id);
    }
    @Override
    @Transactional(readOnly = true)
    public User getUserByID(int id){
        return this.userDao.getUserByID(id);
    }
   @Override
   @Transactional(readOnly = true)
   public List<User> allUsers(){
     return this.userDao.allUsers();
 }
}
