package com.skn.Learning.threaddemo;
import java.util.jar.Attributes.Name;

public class ThreadDemo2 implements Runnable {
	private String name = "";
	public ThreadDemo2(String name) {
		this.name = name;
	}

	public void run(){
		for(int i=0;i<10;i++){
			System.out.println(name);
		}
	}
	
	public static void main(String[] args) {
		ThreadDemo2 aDemo1 = new ThreadDemo2("aaaaa");
		ThreadDemo2 aDemo2 = new ThreadDemo2("bbbbb");
		
		Thread aThread = new Thread(aDemo1);
		Thread bThread = new Thread(aDemo2);
		
		aThread.start();
		bThread.start();
	}
}
