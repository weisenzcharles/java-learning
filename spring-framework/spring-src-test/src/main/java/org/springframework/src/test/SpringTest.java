package org.springframework.src.test;

import org.springframework.cache.annotation.AnnotationCacheOperationSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		HelloService helloService = applicationContext.getBean(HelloService.class);
		helloService.hello();
	}
}
