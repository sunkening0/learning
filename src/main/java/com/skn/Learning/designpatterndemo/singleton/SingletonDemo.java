package com.skn.Learning.designpatterndemo.singleton;

import sun.misc.Signal;

/**
 * 单例模式主要是为了避免因为创建了多个实例造成资源的浪费，且多个实例由于多次调用容易导致结果出现错误，而使用单例模式能够保证整个应用中有且只有一个实例。
 * 单例模式  
 * @author skn
 *
 */
public class SingletonDemo {
	
}

/**
 * 饿汉式  写法1
 * 优点：避免了线程同步问题
 * 缺点：在类加载的时候进行了实例化，没实现懒加载，会占用内存（可以忽略）
 * 推荐使用此方式
 * @author skn
 *
 */
class SingletonDemo1 {

	private static SingletonDemo singletonDemo = new SingletonDemo();
	public static SingletonDemo getInstance(){
		return singletonDemo;
	}
	
}

/**
 * 饿汉式  写法2  
 *
 */
class SingletonDemo2 {

	private static SingletonDemo singletonDemo = null;
	static{
		singletonDemo = new SingletonDemo();
	}
	public static SingletonDemo getInstance(){
		return singletonDemo;
	}
	
}

/**
 * 懒汉式  写法1
 * 缺点：线程不安全
 * 此方式不可用
 * @author skn
 *
 */
class SingletonDemo3 {

	private static SingletonDemo singletonDemo = null;
	public static SingletonDemo getInstance(){
		if(singletonDemo == null){
			singletonDemo = new SingletonDemo();
		}
		return singletonDemo;
	}
	
}


/**
 * 懒汉式  写法2
 * 缺点：线程安全 但是效率低(每个线程获取实例的时候执行getInstance() 都要进行同步，同步方法的效率比普通方法的效率要低)
 * 此方式不推荐使用
 * @author skn
 *
 */
class SingletonDemo4 {

	private static SingletonDemo singletonDemo = null;
	public static synchronized SingletonDemo getInstance(){
		if(singletonDemo == null){
			singletonDemo = new SingletonDemo();
		}
		return singletonDemo;
	}
	
}

/**
 * 懒汉式  写法3
 * 缺点：线程不安全
 * 此方式不可用
 * @author skn
 *
 */
class SingletonDemo5 {

	private static SingletonDemo singletonDemo = null;
	public static SingletonDemo getInstance(){
		
		if(singletonDemo == null){
			synchronized(SingletonDemo5.class){
				singletonDemo = new SingletonDemo();				
			}
		}
		return singletonDemo;
	}
	
}

/**
 * 懒汉式  写法4
 * 双重校验锁[推荐用]
 * 优点：保证了延迟加载且线程安全
 * 此方式推荐使用
 * @author skn
 *
 */
class SingletonDemo6 {

	private static SingletonDemo singletonDemo = null;
	public static SingletonDemo getInstance(){
		
		if(singletonDemo == null){
			synchronized(SingletonDemo5.class){
				if(singletonDemo == null){
					singletonDemo = new SingletonDemo();									
				}
			}
		}
		return singletonDemo;
	}
	
}

/**
 * 懒汉式  写法5 （内部类）
 * 优点：避免了线程不安全，延迟加载，效率高。
 * 静态内部类在SingletonDemo7被加载时并不会被立即实例化，而是在需要实例化时，调用getInstance方法，才会装载SingletonHolder类，从而完成Singleton的实例化。
 * 此方式推荐使用
 * @author skn
 *
 */
class SingletonDemo7 {
	
	private static class Singleton{
		private static SingletonDemo singletonDemo = new SingletonDemo();
	}
	public static SingletonDemo getInstance(){
		return Singleton.singletonDemo;
	}
	
}

/**
 * 懒汉式  写法6 （枚举）
 * 优点：借助JDK1.5中添加的枚举来实现单例模式。不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象。
 * 此方式极推荐使用
 * @author skn
 *
 */
class SingletonDemo8 {
	private SingletonDemo8(){}
    public static SingletonDemo8 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }
    private static enum Singleton{
        INSTANCE;
        
        private SingletonDemo8 singleton;
        //JVM会保证此方法绝对只调用一次
        private Singleton(){
            singleton = new SingletonDemo8();
        }
        public SingletonDemo8 getInstance(){
            return singleton;
        }
    }

	
}
