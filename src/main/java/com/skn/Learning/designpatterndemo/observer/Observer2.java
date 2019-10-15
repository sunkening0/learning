package com.skn.Learning.designpatterndemo.observer;

/**
 * 模拟一个观察者2
* 类名称：Observer1   
* 类描述：   
* 创建人：skn   
* 创建时间：2019年9月22日 下午10:27:40   
* @version
 */
public class Observer2 implements Observer{

	private Subject subject;

	public Observer2(Subject subject) {
		this.subject = subject;
		subject.registerObserver(this);
	}

	
	public void update(String msg) {
		System.out.println("observer2 得到 3D 号码  -->" + msg + ", 我要记下来。");
	}

}
