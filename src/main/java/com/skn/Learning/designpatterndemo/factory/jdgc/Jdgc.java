package com.skn.Learning.designpatterndemo.factory.jdgc;

/**
 * 简单工厂模式
 * 静态 简单 工厂模式是一类 当新增一个产品 必须在工厂类的方法里面添加一个分支 不符开闭 
 * 缺点：把所有类型的对象集中在一种工厂创建。当产品对象在以后出现新的类型以及类型结构变得复杂，这个工厂就会显得简单混乱。
 * @author skn
 *
 */
public class Jdgc {
	public IFruit createFruit(String type){		
		IFruit fruit = null;		
		if (type.equals("apple")){			
			fruit = new Apple(); 		
		} else if (type.equals("banana")){			
			fruit = new Banana();		
		}	
		return fruit;	
	}
}
