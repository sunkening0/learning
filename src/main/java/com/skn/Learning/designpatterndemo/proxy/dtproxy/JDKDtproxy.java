package com.skn.Learning.designpatterndemo.proxy.dtproxy;

import java.lang.reflect.Proxy;

import com.skn.Learning.designpatterndemo.proxy.jtproxy.BuyHouseImpl;
import com.skn.Learning.designpatterndemo.proxy.jtproxy.IBuyHouse;

/**(jdk动态代理)
 * 动态代理是在程序运行时通过反射机制动态创建的。
 * https://www.cnblogs.com/daniels/p/8242592.html
 * @author skn
 *
 */
public class JDKDtproxy {

	public static void main(String[] args) {
		//IBuyHouse buyHouse = new BuyHouseImpl();
		Test test = new Test();
//		注意Proxy.newProxyInstance()方法接受三个参数：
//		ClassLoader loader:指定当前目标对象使用的类加载器,获取加载器的方法是固定的
//		Class<?>[] interfaces:指定目标对象实现的接口的类型,使用泛型方式确认类型
//		InvocationHandler:指定动态处理器，执行目标对象的方法时,会触发事件处理器的方法
		
		IBuyHouse proxyBuyHouse = (IBuyHouse) Proxy.newProxyInstance(Test.class.getClassLoader(),
				new Class[] { Test.class }, new DynamicProxyHandler(test));
		proxyBuyHouse.buyHosue();
	}

}