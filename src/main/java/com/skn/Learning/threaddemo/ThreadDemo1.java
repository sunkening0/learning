package com.skn.Learning.threaddemo;
import java.util.jar.Attributes.Name;

public class ThreadDemo1 extends Thread {
	private String name = "";
	public ThreadDemo1(String name) {
		this.name = name;
	}
	@Override
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println(name + "-----" + currentThread().getName());
		}
	}
	
	public void write(){
		System.out.println("反射测试");
	}
	
	private void wir(String ss){
		System.out.println("反射私有方法"+ss);
	}
	
	public static void main(String[] args) {
		ThreadDemo1 aDemo1 = new ThreadDemo1("aaaaa");
		ThreadDemo1 aDemo2 = new ThreadDemo1("bbbbb");
		
		aDemo1.start();
		aDemo2.start();
	}
}
