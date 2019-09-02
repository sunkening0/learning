package com.skn.Learning.designpatterndemo.strategy;

public abstract class Role {
	protected String name;
	
	protected IAttackBehavior attackBehavior;
	protected IRunBehavior runBehavior;
	
	public Role setAttackBehavior(IAttackBehavior attackBehavior){
		this.attackBehavior = attackBehavior;
		return this;
	}
	
	public Role setRunBehavior(IRunBehavior runBehavior){
		this.runBehavior = runBehavior;
		return this;
	}
	
	public void attack(){
		attackBehavior.attack();
	}
	
	public void run(){
		runBehavior.run();
	}
}
