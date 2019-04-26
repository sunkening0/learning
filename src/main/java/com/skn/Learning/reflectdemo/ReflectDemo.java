package com.skn.Learning.reflectdemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import com.skn.Learning.threaddemo.ThreadDemo1;


/**
 * 创建反射的三种方式   一般常用第三种
 * @author skn
 *
 */
public class ReflectDemo {
	
	@Test
	public void test1() {
		ThreadDemo1 ther1 = new ThreadDemo1("123");
		ThreadDemo1 ther2 = new ThreadDemo1("123");
		
		Class oClass1 = ther1.getClass();
		Class oClass2 = ther2.getClass();
		
		System.out.println(oClass1 == oClass2);
	}
	
	@Test
	public void test2() {
		
		Class oClass1 = ThreadDemo1.class;
		Class oClass2 = ThreadDemo1.class;
		
		System.out.println(oClass1 == oClass2);
	}
	
	@Test
	public void test3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		//获取字节码对象
		Class oClass1 = Class.forName("threadDemo.ThreadDemo1");//要写全路径 
		Class oClass2 = Class.forName("threadDemo.ThreadDemo1");
		
		System.out.println(oClass1 == oClass2);
		
		//创建实例(无参构造函数  对象创建)
		//ThreadDemo1 threadDemo1 = (ThreadDemo1) oClass1.newInstance();
		//ThreadDemo1 threadDemo2 = (ThreadDemo1) oClass1.newInstance();
		
		//获取构造器对象（用于有参构造函数对象创建）
		Constructor constructor = oClass1.getConstructor(String.class);
		ThreadDemo1 threadDemo1 = (ThreadDemo1) constructor.newInstance("erwewrer");
		ThreadDemo1 threadDemo2 = (ThreadDemo1) constructor.newInstance("werwe");
		
		//获取字段(该方法默认获取公共的字段public  包含父类)
		 //oClass1.getField("name");
		 
		 //获取本类字段  但包含私有
		 Field field = oClass1.getDeclaredField("name");
		
		
		//对私有字段的访问取消权限检查(暴力访问)
		field.setAccessible(true);
		String name = (String) field.get(threadDemo1);
		System.out.println(name);

		
		//获取方法列表
//		Method[] methods = oClass1.getMethods(); //获取的都是公共方法
//		methods = oClass1.getDeclaredMethods();//获取本类中方法  包含私有
//		for(Method method:methods){
//			System.out.println(method.getName());
//		}
		
		Method method = oClass1.getDeclaredMethod("wir", String.class);
		method.setAccessible(true);
		method.invoke(threadDemo1, "haha");
		
		Method method1 = oClass1.getMethod("write", null);
		method1.invoke(threadDemo1, null);
	}
}
