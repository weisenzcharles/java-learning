package org.charles.springboot.redisson.controller;

import org.redisson.RedissonMultiLock;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class RedisController {
    @Autowired
    RedissonClient redissonClient;

    @GetMapping("/redis/test")
    public String index() {
        redissonClient.getBucket("test").set("hello redis!");
        String test = (String) redissonClient.getBucket("test").get();
        System.out.println(test);


        return test;
    }

    @GetMapping("/redis/lock")
    public String lock() {
        // 普通加锁
        RLock lock = redissonClient.getLock("lock");
        lock.lock();

        // 加锁以后 10 秒钟自动解锁
        // 无需调用 unlock 方法手动解锁
        lock.lock(10, TimeUnit.SECONDS);

        // 尝试加锁，最多等待 100 秒，上锁以后 10 秒自动解锁
        boolean res = false;
        try {
            res = lock.tryLock(100, 10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (res) {
            try {

            } finally {
                lock.unlock();
            }
        }

        return "lock";
    }

    @GetMapping("/redis/fairLock")
    public String fairLock() {
        // 公平锁
        RLock fairLock = redissonClient.getFairLock("lock");
        // 最常见的使用方法
        fairLock.lock();
        return "fairLock";
    }


    public String linkLock() {
        RLock lock1 = redissonClient.getLock("lock1");  // redis 实例 1
        RLock lock2 = redissonClient.getLock("lock2");  // redis 实例 2
        RLock lock3 = redissonClient.getLock("lock3");  // redis 实例 3

        RedissonMultiLock lock = new RedissonMultiLock(lock1, lock2, lock3);
        // 同时加锁：lock1 lock2 lock3
        // 为加锁等待 100 秒时间，并在加锁成功 10 秒钟后自动解开
        try {
            boolean res = lock.tryLock(100, 10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock.unlock();
        return "linkLock";
    }

    public String readWriteLock() {
        RReadWriteLock readWriteLock = redissonClient.getReadWriteLock("anyRWLock");
        RLock readLock = readWriteLock.readLock();
        // 读锁，最多等待 100 秒，上锁以后 10 秒自动解锁
        try {
            boolean res1 = readLock.tryLock(100, 10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 写锁
        RLock writeLock = readWriteLock.writeLock();
        try {
            boolean res2 = writeLock.tryLock(100, 10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

return  "readWriteLock";
    }
}
