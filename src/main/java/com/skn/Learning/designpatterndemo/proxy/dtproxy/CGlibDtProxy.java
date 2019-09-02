package com.skn.Learning.designpatterndemo.proxy.dtproxy;

import com.skn.Learning.designpatterndemo.proxy.jtproxy.BuyHouseImpl;
import com.skn.Learning.designpatterndemo.proxy.jtproxy.IBuyHouse;

/**
 * cglib动态代理
 * JDK实现动态代理需要实现类通过接口定义业务方法，对于没有接口的类，如何实现动态代理呢，这就需要CGLib了。
 * CGLib采用了非常底层的字节码技术，其原理是通过字节码技术为一个类创建子类，并在子类中采用方法拦截的技术拦截所有父类方法的调用，顺势织入横切逻辑。
 * 但因为采用的是继承，所以不能对final修饰的类进行代理。JDK动态代理与CGLib动态代理均是实现Spring AOP的基础。
 * @author skn
 *
 */
public class CGlibDtProxy {
	public static void main(String[] args){
        //IBuyHouse buyHouse = new BuyHouseImpl();
		Test test = new Test();
        CglibProxy cglibProxy = new CglibProxy();
        //BuyHouseImpl buyHouseCglibProxy = (BuyHouseImpl) cglibProxy.getInstance(test);
        Test buyHouseCglibProxy = (Test) cglibProxy.getInstance(test);
        buyHouseCglibProxy.test();
    }

}
