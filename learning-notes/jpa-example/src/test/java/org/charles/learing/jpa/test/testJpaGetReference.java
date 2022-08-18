package org.charles.learing.jpa.test;

import org.charles.learning.jpa.entity.Order;
import org.charles.learning.jpa.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class testJpaGetReference {
    @Test
    public void testQueryUser() {
        User user = entityManager.getReference(User.class, Long.valueOf(12));
        System.out.println(user);
    }
    @Test
    public void testQueryOrder() {
        Order order = entityManager.getReference(Order.class, Long.valueOf(5));
        System.out.println(order);
    }

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
}
