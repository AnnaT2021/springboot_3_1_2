package com.test_springboot.springboot_3_1_2.dao;

import com.test_springboot.springboot_3_1_2.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public void add(User user){
        entityManager.persist(user);
    }

    @Override
    public void update(int id, User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserByID(int id){
     return entityManager.find(User.class, id);
    }

    @Override
    public void delete(int id){
        entityManager.remove(getUserByID(id));
    }

  @Override
  @SuppressWarnings("unchecked")
   public List<User> allUsers(){
      List<User> userList = entityManager
              .createQuery("FROM User", User.class).getResultList();
      return userList;
      }
}
