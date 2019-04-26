package com.skn.Learning.threaddemo;
import java.util.jar.Attributes.Name;

/**
 * ����thread.join() ���÷�
 * ʹ�ó��� ����ʱ����һ���߳�   ����ǰ���߳�cpuʹ��Ȩ�ͷ�  ����ʱ�߳�ִ�����ټ���ִ��
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
		//thread1.join();
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
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int x = 0; x < i; x++) {
				System.out.println(c + "----hahahhahahahha" + x + "��");
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
			System.out.println(x + "----��" + x + "��");
			Thread.yield(); //��ʱ�ͷ���Դ  ��֤�����߳�Ҳ��ִ�л���
		}

	}
}
