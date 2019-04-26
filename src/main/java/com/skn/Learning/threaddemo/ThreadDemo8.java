package com.skn.Learning.threaddemo;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.jar.Attributes.Name;

/**
 * 线程池
 * 
 * @author skn
 *
 */
public class ThreadDemo8 implements Runnable {
	private int ticket = 10;


	public void run(){
		while(ticket > 0){
			System.out.println(Thread.currentThread().getName()+ "-------" + (ticket--));
		}
	}
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		executorService.execute(new ThreadDemo8());
		executorService.execute(new ThreadDemo8());
		executorService.execute(new ThreadDemo8());
		
		executorService.shutdown();
	}
}
