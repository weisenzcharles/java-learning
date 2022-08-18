package org.charles.springboot.transaction.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {

    @Transactional
    public void parent() {
        System.out.println("父亲的方法！");
        child();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void child() {
        System.out.println("孩子的方法！");
    }

}
