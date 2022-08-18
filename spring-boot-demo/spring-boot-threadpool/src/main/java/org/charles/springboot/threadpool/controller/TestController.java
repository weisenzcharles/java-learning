package org.charles.springboot.threadpool.controller;

import org.charles.springboot.threadpool.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @GetMapping("/test")
    public void test() throws InterruptedException {

        for (int i = 1; i <= 30; i++) {
            threadPoolTaskExecutor.execute(new Task(i));
        }
//
//        threadPoolTaskExecutor.execute(() -> System.out.println("threadPoolTaskExecutor.execute 创建线程"));
//
//        threadPoolTaskExecutor.submit(() -> System.out.println("threadPoolTaskExecutor.submit 创建线程"));

        Thread.sleep(1000);
    }

}
