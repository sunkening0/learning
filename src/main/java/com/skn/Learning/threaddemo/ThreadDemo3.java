package com.skn.Learning.threaddemo;
import java.util.jar.Attributes.Name;

public class ThreadDemo3 implements Runnable {
	private int ticket = 100;


	public void run(){
		while(ticket > 0){
			System.out.println(Thread.currentThread().getName()+ "-------" + (ticket--));
		}
	}
	
	public static void main(String[] args) {
		ThreadDemo3 aDemo1 = new ThreadDemo3();
		//ThreadDemo3 aDemo2 = new ThreadDemo3();
		
		Thread aThread = new Thread(aDemo1);
		Thread bThread = new Thread(aDemo1);
		
		aThread.start();
		bThread.start();
	}
}
