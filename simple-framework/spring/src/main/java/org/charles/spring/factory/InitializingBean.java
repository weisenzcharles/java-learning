package org.charles.spring.factory;

public interface InitializingBean {
    void afterPropertiesSet() throws Exception;
}
