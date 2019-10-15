package com.skn.Learning.designpatterndemo.observer;

/**
 * 主题接口，所有的主题必须实现此接口
* 类名称：Subject   
* 类描述：   
* 创建人：skn   
* 创建时间：2019年9月22日 下午10:24:56   
* @version
 */
public interface Subject {
	/** 
	 * 注册一个观察着
	 * @param observer 
	 */
	public void registerObserver(Observer observer);

	/** 
	 * 移除一个观察者 
	 * @param observer 
	 */
	public void removeObserver(Observer observer);

	/** 
	 * 通知所有的观察着
     */
	public void notifyObservers();
}
