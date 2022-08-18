package org.charles.springboot.jpa.datasource.customer.repository;

import org.charles.springboot.jpa.datasource.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/*
 * 客户仓储类。
 */
@Component
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
