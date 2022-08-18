package org.charles.learning.jpa;

import org.charles.learning.jpa.entity.User;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin(); // 开启事务

        User user = new User().setName("charles")
                .setEmail("master@weilog.net")
                .setDescription("charles zhang")
                .setPassword("123456").setAddress("浙江省杭州市")
                .setPhone("13800001380")
                .setBirthday(new Date(89, 1, 1))
                .setCreatedTime(new Date());
        LocalDate localDate = LocalDate.of(1989, 01, 05);
        System.out.println(localDate);
        
        entityManager.persist(user);
        System.out.println(user);

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
