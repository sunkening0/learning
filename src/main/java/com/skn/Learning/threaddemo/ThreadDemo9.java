package com.skn.Learning.threaddemo;

/**
 * 测试线程sleep后，锁释放不释放，不释放的话 其他线程是否会阻塞
 * 结果证明：sleep执行后  锁不会释放   其他线程阻塞
* 类名称：ThreadDemo9   
* 类描述：   
* 创建人：skn   
* 创建时间：2019年9月23日 上午8:46:41   
* @version
 */
public class ThreadDemo9 implements Runnable {
	private String syn = "heiheihie";
	private String name = "";
	public ThreadDemo9(String name) {
		this.name = name;
	}

	public void run(){
		
		synchronized (this) {
			for(int i=0;i<1;i++){
				System.out.println(name);
			}
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		
		for(int i=0;i<10;i++){
			ThreadDemo9 aDemo1 = new ThreadDemo9(i+"--hahahhahaha");
			Thread aThread = new Thread(aDemo1);
			aThread.start();
		}
		
	}
}
