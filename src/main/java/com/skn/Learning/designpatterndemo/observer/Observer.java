package com.skn.Learning.designpatterndemo.observer;

/**
 * 观察者模式（以微信公众服务为例）
 * 定义了对象之间的一对多的依赖，这样一来，当一个对象改变时，它的所有的依赖者都会收到通知并自动更新
 * @author skn
 * https://blog.csdn.net/lmj623565791/article/details/24179699
 *
 */

/**
 * 
* 类名称：Observer   
* 类描述：   所有的观察者需要实现此接口
* 创建人：skn   
* 创建时间：2019年9月22日 下午10:24:43   
* @version
 */
public interface Observer {
	public void update(String msg);
}
