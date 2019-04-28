package com.skn.Learning.designpatterndemo.factory.jtgc;

/**
 * 静态工厂类本身不是静态的，它里面的方法是静态的，方法返回的要是实现了通用接口的对象的实例强转过来的通用接口对象
 * 缺点：静态方法不能被继承和重写
 * @author skn
 *
 */
public class JtFactory {
	public static IFruit getFruit(String type){
		IFruit fruit = null;
		try {
			fruit = (IFruit)Class.forName("com.skn.Learning.designpatterndemo.factory.jtgc"+type).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fruit;
	}
}
