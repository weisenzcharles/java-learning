package org.charles.spring.test.service;

import org.charles.spring.annotation.Component;

@Component("goodService")
public class GoodServiceImpl implements GoodService {
    @Override
    public void test() {
        System.out.println("goodService.test()");
    }

    @Override
    public void list(String id) {
        System.out.println("goodService.list(), params -> " + id);
    }
}
