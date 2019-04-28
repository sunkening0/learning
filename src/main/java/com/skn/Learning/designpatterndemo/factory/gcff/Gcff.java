package com.skn.Learning.designpatterndemo.factory.gcff;

/**
 * 工厂方法模式
 * 步骤1： 创建抽象工厂类，定义具体工厂的公共接口； 
 * 步骤2： 创建抽象产品类 ，定义具体产品的公共接口； 
 * 步骤3： 创建具体产品类（继承抽象产品类） & 定义生产的具体产品； 
 * 步骤4：创建具体工厂类（继承抽象工厂类），定义创建对应具体产品实例的方法； 
 * 步骤5：外界通过调用具体工厂类的方法，从而创建不同具体产品类的实例
 * 缺点：一个工厂只能指定一个产品   如果要增加新产品 就要增加对应的工厂类
 * @author skn
 *
 */
public class Gcff {
	public static void main(String[] args) {
		PhoneFactory nFactory = new NokiaFactory();
		Phone nPhone = nFactory.creatPhone();
		nPhone.show();
		
		PhoneFactory hFactory = new HuaweiFactory();
		Phone hPhone = hFactory.creatPhone();
		hPhone.show();
	}
}
