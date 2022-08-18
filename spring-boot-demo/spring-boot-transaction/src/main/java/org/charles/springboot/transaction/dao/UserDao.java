package org.charles.springboot.transaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 转出
     *
     * @param outUserId
     * @param money
     */
    public void outMoney(long outUserId, int money) {
        jdbcTemplate.update("update money set money = money - ? where id = ?", money, outUserId);
    }

    /**
     * 转入
     *
     * @param inUserId
     * @param money
     */
    public void inMoney(long inUserId, int money) {
        jdbcTemplate.update("update money set money = money + ? where id = ?", money, inUserId);
    }
}
