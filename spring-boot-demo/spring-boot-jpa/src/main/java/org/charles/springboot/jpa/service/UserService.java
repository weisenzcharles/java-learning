package org.charles.springboot.jpa.service;

import org.charles.springboot.jpa.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    Page<User> listUser(Pageable pageable);

    Page<User> listUser(Pageable pageable, String query);

    User add(User tag);

    void deleteById(Long id);

    User update(User tag);

    User getById(Long id);

    List<User> query(String title, int pageIndex, int pageSize);

    List<User> query(int pageIndex, int pageSize);
}
