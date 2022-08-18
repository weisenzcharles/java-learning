package org.charles.learing.jpa.test;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import org.charles.learning.jpa.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testJpaFind {

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
    public void testFind() {
        User user = entityManager.find(User.class, Long.valueOf(4));
        System.out.println(user);
    }

}
