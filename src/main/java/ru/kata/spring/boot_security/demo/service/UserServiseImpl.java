package ru.kata.spring.boot_security.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

@Service
public class UserServiseImpl implements UserService {


    private UserDao dao;

    public UserServiseImpl() {
    }

    @Autowired
    public UserServiseImpl(UserDao dao) {
        this.dao = dao;
    }


    @Override
    public List<User> getAllUsers() {
        return (List<User>) dao.findAll();
    }

    @Override
    public User getUser(Long id) {
        return (User) dao.findById(id).get();
    }


    @Transactional
    @Override
    public void saveUser(User user) {
        dao.save(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        dao.save(user);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        dao.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = dao.findUserByEmail(username);
        return user;

    }
}
