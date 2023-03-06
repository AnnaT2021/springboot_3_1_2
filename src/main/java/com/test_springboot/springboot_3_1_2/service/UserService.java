package com.test_springboot.springboot_3_1_2.service;

import com.test_springboot.springboot_3_1_2.model.User;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public interface UserService {

    void add(User user);
    void update(int id, User user);
    void delete(int id);
    User getUserByID(int id);
    List<User> allUsers();
}
