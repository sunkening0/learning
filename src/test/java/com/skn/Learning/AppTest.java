package com.skn.Learning;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.skn.Learning.spring.Apple;
import com.skn.Learning.spring.TestConfig;
import com.skn.Learning.spring.test.TestService;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void getSpringBeans(){
    	AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
    	String[] beannames= annotationConfigApplicationContext.getBeanDefinitionNames();
    	System.out.println(annotationConfigApplicationContext.getBeanDefinitionCount());
    	for(String s:beannames){
    		System.out.println(s);
    	}
    	TestService testService = annotationConfigApplicationContext.getBean(TestService.class);
    	testService.test1();
    	
    	/*Apple apple = annotationConfigApplicationContext.getBean(Apple.class);
    	System.out.println(apple);*/
    	
    	annotationConfigApplicationContext.close();
    }
}
