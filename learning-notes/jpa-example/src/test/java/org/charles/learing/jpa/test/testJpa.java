package org.charles.learing.jpa.test;

import org.charles.learning.jpa.entity.Order;
import org.charles.learning.jpa.entity.OrderItem;
import org.charles.learning.jpa.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.Map;

public class testJpa {
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
    public void testPersist() {
        // 获取设置属性
        Map<String, Object> maps = entityManager.getProperties();
        System.out.println(maps);

        User user = new User().setName("charles").setEmail("master@weilog.net")
                .setDescription("charles zhang").setPassword("123456")
                .setAddress("浙江省杭州市").setPhone("13800001380")
                .setBirthday(new Date(89, 1, 1)).setCreatedTime(new Date());
        entityManager.persist(user);
        System.out.println(user);
    }

    @Test
    public void testOrder() {
        Order order = new Order();
        order.setName("测试订单-10");
        entityManager.persist(order);

        OrderItem item1 = new OrderItem();
        item1.setName("测试订单-项目-05");
        item1.setOrderId(order.getId());
        OrderItem item2 = new OrderItem();
        item2.setName("测试订单-项目-06");
        item2.setOrderId(order.getId());
        entityManager.persist(item1);
        entityManager.persist(item2);

        entityManager.flush();
//        order.getItems().add(item1);
//        order.getItems().add(item2);

        System.out.println(order);
    }


}
