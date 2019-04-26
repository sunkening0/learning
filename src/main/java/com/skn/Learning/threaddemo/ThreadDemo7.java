package com.skn.Learning.threaddemo;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.jar.Attributes.Name;

/**
 * 多生产者多消费者
 * 
 * @author skn
 *
 */
public class ThreadDemo7 {

	public static void main(String[] args) throws InterruptedException {
		Resource2 resource = new Resource2();
		Runnable runnable1 = new Producer2(resource);
		Runnable runnable2 = new Consumer2(resource);

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

class Resource2{
	Lock lock = new ReentrantLock();
	//通过已有的锁获取两组锁上的监视器对象
	Condition condition1 = lock.newCondition();
	Condition condition2 = lock.newCondition();
	
	final Object[] items = new Object[100];
	int putptr=0,takeptr=0,count=0;
	
	public void put(Object o) {
		lock.lock();
		try{
			while(count == items.length){   
				condition1.await();				
			}
			items[putptr] = o;
			System.out.println("生产者---"+o+"------"+putptr);
			if(++putptr == items.length){
				putptr = 0;
			}
			++count;
			condition2.signal();
		}catch(Exception e){
			
		}finally{
			lock.unlock();
		}
		
	}
	public Object out(){
		lock.lock();
		try{
			while(count == 0){
				condition2.wait();				
			}
			Object object = items[takeptr];
			System.out.println("消费者---"+object+"---"+takeptr);
			if(++takeptr == items.length){
				takeptr = 0;
			}
			--count;
			condition1.signal();
			return object;
		}catch(Exception e){
			
		}finally{
			lock.unlock();
			return null;
		}
		
	}
	
}

class Producer2 implements Runnable{
	private Resource2 resource;
	public Producer2(Resource2 resource) {
		this.resource = resource;
	}
	
	public void run(){
		while(true){
			resource.put(new Object());
		}
	}
}

class Consumer2 implements Runnable{
	private Resource2 resource;
	public Consumer2(Resource2 resource) {
		this.resource = resource;
	}
	public void run(){
		while(true){
			resource.out();
		}
	}
}
