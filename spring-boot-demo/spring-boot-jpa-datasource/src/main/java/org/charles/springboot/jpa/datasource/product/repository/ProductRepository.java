package org.charles.springboot.jpa.datasource.product.repository;

import org.charles.springboot.jpa.datasource.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/*
 * 产品仓储类。
 */
@Component
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
