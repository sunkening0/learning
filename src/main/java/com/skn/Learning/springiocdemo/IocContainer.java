package com.skn.Learning.springiocdemo;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 1。实例化bean
 * 2、保存bean
 * 3、提供bean
 * 4、每一个bean要产生与之对应的beanid
 * @author skn
 *
 */
public class IocContainer {
	private Map<String, Object> beans = new ConcurrentHashMap<String, Object>();
	
	public Object getBean(String beanId){
		return beans.get(beanId);
	}
	
	public void setBean(Class<?> clazz,String beanId,String... paramBeanIds){
		//1、组装构造方法所需的参数值
		Object[] paramValues = new Object[paramBeanIds.length];
		for(int i=0;i<paramBeanIds.length;i++){
			paramValues[i] = beans.get(paramBeanIds[i]);
		}
		//2、调用构造方法实例化bean
		Object bean = null;
		for(Constructor<?> constructor:clazz.getConstructors()){
			try{
				bean = constructor.newInstance(paramValues);
			}catch(Exception e){
				
			}
		}
		if(bean == null){
			throw new RuntimeException("找不到合适的构造方法去实例化对象");
		}
		//3、奖实例化的bean  放入  beans
		beans.put(beanId, bean);
	}
}
