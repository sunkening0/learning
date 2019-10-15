package com.skn.Learning.designpatterndemo.observer;

/**
 * 模拟一个观察者1
* 类名称：Observer1   
* 类描述：   
* 创建人：skn   
* 创建时间：2019年9月22日 下午10:27:40   
* @version
 */
public class Observer1 implements Observer{

	private Subject subject;

	public Observer1(Subject subject) {
		this.subject = subject;
		subject.registerObserver(this);
	}

	
	public void update(String msg) {
		System.out.println("observer1 得到 3D 号码  -->" + msg + ", 我要记下来。");
	}

}
