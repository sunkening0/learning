package com.skn.Learning.designpatterndemo.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 类名称：ObjectFor3D 
 * 类描述： 
 * 创建人：skn 
 * 创建时间：2019年9月22日 下午10:25:46
 * 
 * @version
 */
public class ObjectFor3D implements Subject {
	private List<Observer> observers = new ArrayList<Observer>();
	/** * 3D彩票的号码 */
	private String msg;

	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		int index = observers.indexOf(observer);
		if (index >= 0) {
			observers.remove(index);
		}
	}

	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(msg);
		}
	}

	/** 
	 * 主题更新消息 
	 * @param msg 
	 */
	public void setMsg(String msg) {
		this.msg = msg;
		notifyObservers();
	}
}
