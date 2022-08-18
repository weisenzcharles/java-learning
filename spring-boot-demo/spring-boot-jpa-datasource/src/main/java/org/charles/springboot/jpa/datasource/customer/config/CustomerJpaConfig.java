package org.charles.springboot.jpa.datasource.customer.config;

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
@EnableJpaRepositories(basePackages = CustomerJpaConfig.REPOSITORY_PACKAGE, entityManagerFactoryRef = "customerEntityManagerFactory", transactionManagerRef = "customerTransactionManager")
public class CustomerJpaConfig {
    static final String REPOSITORY_PACKAGE = "org.charles.springboot.jpa.datasource.customer.repository";
    private static final String ENTITY_PACKAGE = "org.charles.springboot.jpa.datasource.customer.entity";


    @Primary
    @Bean(name = "customerJpaProperties")
    @ConfigurationProperties(prefix = "spring.jpa.customer")
    public JpaProperties jpaProperties() {
        return new JpaProperties();
    }


    @Primary
    @Bean(name = "customerEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("customerDataSource") DataSource customerDataSource, @Qualifier("customerJpaProperties") JpaProperties jpaProperties, EntityManagerFactoryBuilder builder) {
        return builder.dataSource(customerDataSource).properties(jpaProperties.getProperties()).packages(ENTITY_PACKAGE).persistenceUnit("customerPersistenceUnit").build();
    }


    @Primary
    @Bean(name = "customerEntityManager")
    public EntityManager entityManager(@Qualifier("customerEntityManagerFactory") EntityManagerFactory factory) {
        return factory.createEntityManager();
    }


    @Primary
    @Bean(name = "customerTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("customerEntityManagerFactory") EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }
}
