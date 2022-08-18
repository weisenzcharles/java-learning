package org.charles.springboot.transaction.service;

import org.charles.springboot.transaction.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 转账测试
     * //
     */
    @Transactional
    public void transfer(long outUserId, long inUserId, int money) {
        userDao.outMoney(outUserId, money);
//        int i = 1 / 0;
        userDao.inMoney(inUserId, money);
    }

//    @Autowired
//    private TransactionTemplate transactionTemplate;
//
//    public void transfer(long outUserId, long inUserId, int money) {
//        transactionTemplate.execute(status -> { // 事务模板
//            userDao.outMoney(outUserId, money);
////            int i = 1 / 0;
//            userDao.inMoney(inUserId, money);
//            return null;    // 事务模板必须返回null
//        });
//    }
}
