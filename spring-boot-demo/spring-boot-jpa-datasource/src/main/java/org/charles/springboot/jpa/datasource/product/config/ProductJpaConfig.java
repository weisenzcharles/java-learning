package org.charles.springboot.jpa.datasource.product.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = ProductJpaConfig.REPOSITORY_PACKAGE, entityManagerFactoryRef = "productEntityManagerFactory", transactionManagerRef = "productTransactionManager")
public class ProductJpaConfig {
    static final String REPOSITORY_PACKAGE = "org.charles.springboot.jpa.datasource.product.repository";
    private static final String ENTITY_PACKAGE = "org.charles.springboot.jpa.datasource.product.entity";


    @Bean(name = "productJpaProperties")
    @ConfigurationProperties(prefix = "spring.jpa.product")
    public JpaProperties jpaProperties() {
        return new JpaProperties();
    }


    @Primary
    @Bean(name = "productEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("productDataSource") DataSource productDataSource, @Qualifier("productJpaProperties") JpaProperties jpaProperties, EntityManagerFactoryBuilder builder) {
        return builder.dataSource(productDataSource).properties(jpaProperties.getProperties()).packages(ENTITY_PACKAGE).persistenceUnit("productPersistenceUnit").build();
    }


    @Primary
    @Bean(name = "productEntityManager")
    public EntityManager entityManager(@Qualifier("productEntityManagerFactory") EntityManagerFactory factory) {
        return factory.createEntityManager();
    }


    @Primary
    @Bean(name = "productTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("productEntityManagerFactory") EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }
}