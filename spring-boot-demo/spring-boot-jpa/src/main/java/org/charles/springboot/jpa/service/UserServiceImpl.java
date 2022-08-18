package org.charles.springboot.jpa.service;

import org.charles.springboot.jpa.domain.User;
import org.charles.springboot.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Page<User> listUser(Pageable pageable) {
        return null;
    }

    @Override
    public Page<User> listUser(Pageable pageable, String query) {
        return null;
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> query(String title, int pageIndex, int pageSize) {
        return userRepository.findAll();
    }

    @Override
    public List<User> query(int pageIndex, int pageSize) {
        return userRepository.findAll();
    }
}
