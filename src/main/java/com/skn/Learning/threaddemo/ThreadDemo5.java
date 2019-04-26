package com.skn.Learning.threaddemo;
import java.util.jar.Attributes.Name;

/**
 * �������߶�������
 * 
 * @author skn
 *
 */
public class ThreadDemo5 {

	public static void main(String[] args) throws InterruptedException {
		Resource resource = new Resource();
		Runnable runnable1 = new Producer(resource);
		Runnable runnable2 = new Consumer(resource);

		Thread thread1 = new Thread(runnable1);
		Thread thread2 = new Thread(runnable1);
		Thread thread3 = new Thread(runnable2);
		Thread thread4 = new Thread(runnable2);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		//thread1.join();
		//thread2.setPriority(Thread.MAX_PRIORITY);
		
		System.out.println("3dfguttjruiyuhjdfbsdhtywertwef");
	}
}

class Resource{
	private String name;
	private int count = 1;
	private boolean flag = false;
	public synchronized void set(String name) {
		while(flag){   //���Ϊtrue  �̵߳ȴ�  ����߳̿�ʼ����
			try{
				this.wait();				
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		this.name = name + count;
		count++;
		System.out.println(Thread.currentThread().getName()+"......�����ߡ���������"+this.name);
		flag = true;
		this.notifyAll();
	}
	public synchronized void out(){
		while(!flag){
			try{
				this.wait();				
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+"......�����ߡ���������"+this.name);
		flag = false;
		this.notifyAll();
	}
	
}

class Producer implements Runnable{
	private Resource resource;
	public Producer(Resource resource) {
		this.resource = resource;
	}
	
	public void run(){
		while(true){
			resource.set("�Ǵ��Ź�");
		}
	}
}

class Consumer implements Runnable{
	private Resource resource;
	public Consumer(Resource resource) {
		this.resource = resource;
	}
	public void run(){
		while(true){
			resource.out();
		}
	}
}
