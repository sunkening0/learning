package com.skn.Learning.reflectdemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import com.skn.Learning.threaddemo.ThreadDemo1;


/**
 * ������������ַ�ʽ   һ�㳣�õ�����
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
		//��ȡ�ֽ������
		Class oClass1 = Class.forName("threadDemo.ThreadDemo1");//Ҫдȫ·�� 
		Class oClass2 = Class.forName("threadDemo.ThreadDemo1");
		
		System.out.println(oClass1 == oClass2);
		
		//����ʵ��(�޲ι��캯��  ���󴴽�)
		//ThreadDemo1 threadDemo1 = (ThreadDemo1) oClass1.newInstance();
		//ThreadDemo1 threadDemo2 = (ThreadDemo1) oClass1.newInstance();
		
		//��ȡ���������������вι��캯�����󴴽���
		Constructor constructor = oClass1.getConstructor(String.class);
		ThreadDemo1 threadDemo1 = (ThreadDemo1) constructor.newInstance("erwewrer");
		ThreadDemo1 threadDemo2 = (ThreadDemo1) constructor.newInstance("werwe");
		
		//��ȡ�ֶ�(�÷���Ĭ�ϻ�ȡ�������ֶ�public  ��������)
		 //oClass1.getField("name");
		 
		 //��ȡ�����ֶ�  ������˽��
		 Field field = oClass1.getDeclaredField("name");
		
		
		//��˽���ֶεķ���ȡ��Ȩ�޼��(��������)
		field.setAccessible(true);
		String name = (String) field.get(threadDemo1);
		System.out.println(name);

		
		//��ȡ�����б�
//		Method[] methods = oClass1.getMethods(); //��ȡ�Ķ��ǹ�������
//		methods = oClass1.getDeclaredMethods();//��ȡ�����з���  ����˽��
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
