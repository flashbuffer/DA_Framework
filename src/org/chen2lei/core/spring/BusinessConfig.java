package org.chen2lei.core.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import org.chen2lei.core.spring.BusinessConfig;

@Configuration
@ComponentScan("org.chen2lei")
@EnableAspectJAutoProxy
public class BusinessConfig {
    private static ApplicationContext CTX = new AnnotationConfigApplicationContext(BusinessConfig.class);
	
    public static <T> T getBean(Class<T> cls){
		return CTX.getBean(cls);
	}

}
