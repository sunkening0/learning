package com.skn.Learning.springiocdemo;

import org.junit.Before;
import org.junit.Test;

public class TestIOC {
	private IocContainer iocContainer = new IocContainer();
	@Before
	public void Before(){
		iocContainer.setBean(AudiCar.class, "audi");
		iocContainer.setBean(BickCar.class, "bick");
		iocContainer.setBean(Zhangsan.class, "zhangsan","audi");
		iocContainer.setBean(Lisi.class, "lisi","bick");
	}
	
	
	@Test
	public void test1(){
		Human zhangsan = (Human) iocContainer.getBean("zhangsan");
		Human lisi = (Human) iocContainer.getBean("lisi");
		
		zhangsan.goHome();
		lisi.goHome();
	}
}
