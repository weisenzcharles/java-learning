package org.charles.learing.jpa.test;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.charles.learning.jpa.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testJpaMerge {

    private EntityTransaction entityTransaction;
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    @Before
    public void before() throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
    }

    @After
    public void after() throws Exception {
        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    public void testMerge() {

        User user = new User().setName("赵四").setEmail("zhaosi@weilog.net")
                .setDescription("赵四").setPassword("123456")
                .setAddress("北京市").setPhone("13802221380")
                .setBirthday(new Date(77, 3, 1)).setCreatedTime(new Date());
        User user2 = entityManager.merge(user);


        System.out.println(user);
        System.out.println(user2);
    }
}
