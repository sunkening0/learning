package com.skn.Learning.designpatterndemo.observer.java;

import java.util.Observable;

/**
 * 使用java内置类实现观察者模式
* 类名称：SubjectFor3d   
* 类描述：   
* 创建人：skn   
* 创建时间：2019年9月22日 下午10:33:00   
* @version
 */
public class SubjectFor3d extends Observable {
	private String msg;

	public String getMsg() {
		return msg;
	}

	/**
	 * 主题更新消息
	 * @param msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
		setChanged();
		notifyObservers();
	}
}
