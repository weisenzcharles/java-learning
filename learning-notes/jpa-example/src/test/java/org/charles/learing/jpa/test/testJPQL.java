package org.charles.learing.jpa.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.charles.learning.jpa.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testJPQL {
    private EntityTransaction entityTransaction;
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    @Test
    public void testCreateQuery() {
        String jpql = "FROM User where id > ?1";
        Query query = entityManager.createQuery(jpql).setParameter(1, Long.valueOf(5));
        List<User> users = query.getResultList();
        System.out.println(users.size());
    }

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
