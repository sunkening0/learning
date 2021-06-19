package com.skn.Learning.threaddemo;
import java.util.jar.Attributes.Name;

/**
 * 测试thread.join() 的用法
 * 使用场景 ：临时假如一个线程   将当前的线程cpu使用权释放  等临时线程执行完再继续执行
 * 
 * @author skn
 *
 */
public class ThreadDemo4 {

	public static void main(String[] args) throws InterruptedException {
		Runnable runnable1 = new PrintChar("a", 10);
		Runnable runnable2 = new PrintNum(10);

		Thread thread1 = new Thread(runnable1);
		Thread thread2 = new Thread(runnable2);

		thread1.start();
		thread2.start();
		thread1.join();
		//thread2.setPriority(Thread.MAX_PRIORITY);
		
		System.out.println("3dfguttjruiyuhjdfbsdhtywertwef");
	}
}

class PrintChar implements Runnable {
	private String c;
	private int i;

	public PrintChar(String c, int i) {
		this.c = c;
		this.i = i;
	}

	public synchronized void run() {
		// TODO Auto-generated method stub
		
		while(true){
			try {
				//this.wait();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int x = 0; x < i; x++) {
				System.out.println(c + "----hahahhahahahha" + x + "次");
			}
		}
			
	}
}

class PrintNum implements Runnable {
	private int i;

	public PrintNum(int i) {
		this.i = i;
	}


	public void run() {
		// TODO Auto-generated method stub
		
		for (int x = 0; x < i; x++) {
			System.out.println(x + "----第" + x + "次");
			Thread.yield(); //临时释放资源  保证其他线程也有执行机会
		}

	}
}
