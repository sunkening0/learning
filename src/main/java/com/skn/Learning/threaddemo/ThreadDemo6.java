package com.skn.Learning.threaddemo;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.jar.Attributes.Name;

/**
 * 多生产者多消费者    Lock用法
 * 
 * @author skn
 *
 */
public class ThreadDemo6 {

	public static void main(String[] args) throws InterruptedException {
		Resource1 resource = new Resource1();
		Runnable runnable1 = new Producer1(resource);
		Runnable runnable2 = new Consumer1(resource);

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

class Resource1{
	private String name;
	private int count = 1;
	private boolean flag = false;
	Lock lock = new ReentrantLock();
	//通过已有的锁获取两组锁上的监视器对象
	Condition condition1 = lock.newCondition();
	Condition condition2 = lock.newCondition();
	public void set(String name) {
		lock.lock();
		try{
			while(flag){   //如果为true  线程等待  输出线程开始工作
				try{
					condition1.await();				
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			this.name = name + count;
			count++;
			System.out.println(Thread.currentThread().getName()+"......生产者。。。。。"+this.name);
			flag = true;
			condition2.signal();
		}catch(Exception e){
			
		}finally{
			lock.unlock();
		}
		
	}
	public synchronized void out(){
		lock.lock();
		try{
			while(!flag){
				try{
					condition2.wait();				
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+"......消费者。。。。。"+this.name);
			flag = false;
			condition1.signal();
		}catch(Exception e){
			
		}finally{
			lock.unlock();
		}
		
		
		
		
	}
	
}

class Producer1 implements Runnable{
	private Resource1 resource;
	public Producer1(Resource1 resource) {
		this.resource = resource;
	}
	
	public void run(){
		while(true){
			resource.set("糖醋排骨");
		}
	}
}

class Consumer1 implements Runnable{
	private Resource1 resource;
	public Consumer1(Resource1 resource) {
		this.resource = resource;
	}
	public void run(){
		while(true){
			resource.out();
		}
	}
}
