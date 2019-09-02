package com.skn.Learning.designpatterndemo.strategy;

/**
 * 策略模式
 * 定义了算法族（各种招式），分别封装起来，让它们之间可相互替换，此模式让算法的变化独立于使用算法的客户。
 * @author skn
 *https://blog.csdn.net/lmj623565791/article/details/24116745
 */
public class Strategy {
	public static void main(String[] args) {
		Role roleA = new RoleA("宁儿");
		
		roleA.setAttackBehavior(new AttackBehavior()).setRunBehavior(new RunBehavior());
		
		System.out.println(roleA.name);
		roleA.attack();
		roleA.run();
	}
}
