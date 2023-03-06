package com.test_springboot.springboot_3_1_2.dao;



import com.test_springboot.springboot_3_1_2.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);
    void update(int id, User user);
    void delete(int id);
    User getUserByID(int id);
    List<User> allUsers();



}
