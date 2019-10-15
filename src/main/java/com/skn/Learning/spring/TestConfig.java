package com.skn.Learning.spring;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 属性use-default-filters="false"和<context:include-filter>要一起使用，表示：只扫描指定注解的类。
            <context:exclude-filter>直接使用，表示：不扫描指定注解的类，其他注解类全部扫描。 
* 类名称：TestConfig   
* 类描述：   
* 创建人：skn   
* 创建时间：2019年10月2日 下午12:34:45   
* @version
 */
@Configuration
@ComponentScan(value="com.skn.Learning.spring",nameGenerator=TestConfig.SpringBeanNameGenerator.class/*,
			includeFilters={@Filter(type=FilterType.ANNOTATION,classes={Service.class})},
			useDefaultFilters=false*/)  
public class TestConfig extends AnnotationBeanNameGenerator{
	
	/*@Bean
	public TestService test1(){
		return new TestService();
	}*/
	
	@Bean("apple")
	public Apple creatApple(){
		Apple apple = new Apple();
		apple.setName("2");
		return apple;
	}
	
	// 1.避免同名类  自己创一个generator
    public static class SpringBeanNameGenerator extends AnnotationBeanNameGenerator {
        @Override
        protected String buildDefaultBeanName(BeanDefinition definition) {
            return definition.getBeanClassName();
        }
    }
	
}
