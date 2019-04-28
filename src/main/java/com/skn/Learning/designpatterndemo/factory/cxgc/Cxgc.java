package com.skn.Learning.designpatterndemo.factory.cxgc;

/**
 * 抽象工厂
 * 工厂方法模式： 只有一个抽象产品类，具体工厂类只能创建一个具体产品类的实例 
 * 抽象工厂模式： 有多个抽象产品类 ，具体工厂类能创建多个具体产品类的实例
 * @author skn
 *
 */
public class Cxgc {
	public static void main(String[] args) {
		PhoneFactory hFactory = new HuaweiFactory();
		hFactory.creatPhoneDc().say();
		hFactory.creatPhonePm().say();
	}
}
