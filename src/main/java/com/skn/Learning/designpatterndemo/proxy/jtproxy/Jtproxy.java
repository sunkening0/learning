package com.skn.Learning.designpatterndemo.proxy.jtproxy;

/**
 * 静态代理 是由程序员创建或特定工具自动生成源代码，在对其编译。在程序员运行之前，代理类.class文件就已经被创建了
 * 
 * 开闭原则，增加功能：代理类除了是客户类和委托类的中介之外，我们还可以通过给代理类增加额外的功能来扩展委托类的功能，
 * 这样做我们只需要修改代理类而不需要再修改委托类，符合代码设计的开闭原则。
 * 代理类主要负责为委托类预处理消息、过滤消息、把消息转发给委托类，以及事后对返回结果的处理等。
 * 代理类本身并不真正实现服务，而是同过调用委托类的相关方法，来提供特定的服务。真正的业务功能还是由委托类来实现，
 * 但是可以在业务功能执行的前后加入一些公共的服务。
 * 例如我们想给项目加入缓存、日志这些功能，我们就可以使用代理类来完成，而没必要打开已经封装好的委托类。
 * 
 * 优点：可以做到在符合开闭原则的情况下对目标对象进行功能扩展。
 * 缺点：我们得为每一个服务都得创建代理类，工作量太大，不易管理。同时接口一旦发生改变，代理类也得相应修改。     
 * 
 * 第一步：创建服务类接口
 * 第二步：实现服务接口
 * 第三步：创建代理类
 * 第四步：编写测试类
 * @author skn
 *
 */
public class Jtproxy {
	public static void main(String[] args) {
        IBuyHouse buyHouse = new BuyHouseImpl();
        buyHouse.buyHosue();
        BuyHouseProxy buyHouseProxy = new BuyHouseProxy(buyHouse);
        buyHouseProxy.buyHosue();
    }

}
