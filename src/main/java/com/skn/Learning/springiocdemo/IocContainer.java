package com.skn.Learning.springiocdemo;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 1��ʵ����bean
 * 2������bean
 * 3���ṩbean
 * 4��ÿһ��beanҪ������֮��Ӧ��beanid
 * @author skn
 *
 */
public class IocContainer {
	private Map<String, Object> beans = new ConcurrentHashMap<String, Object>();
	
	public Object getBean(String beanId){
		return beans.get(beanId);
	}
	
	public void setBean(Class<?> clazz,String beanId,String... paramBeanIds){
		//1����װ���췽������Ĳ���ֵ
		Object[] paramValues = new Object[paramBeanIds.length];
		for(int i=0;i<paramBeanIds.length;i++){
			paramValues[i] = beans.get(paramBeanIds[i]);
		}
		//2�����ù��췽��ʵ����bean
		Object bean = null;
		for(Constructor<?> constructor:clazz.getConstructors()){
			try{
				bean = constructor.newInstance(paramValues);
			}catch(Exception e){
				
			}
		}
		if(bean == null){
			throw new RuntimeException("�Ҳ������ʵĹ��췽��ȥʵ��������");
		}
		//3����ʵ������bean  ����  beans
		beans.put(beanId, bean);
	}
}
