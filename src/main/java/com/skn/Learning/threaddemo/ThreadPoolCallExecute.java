package com.skn.Learning.threaddemo;

import java.util.Random;
import java.util.concurrent.*;
/**
 * 
* 类名称：ThreadPoolCallExecute   
* 类描述：   
* 创建人：skn   
* 创建时间：2019年9月23日 上午1:16:37   
* @version
 */

public class ThreadPoolCallExecute {
	
    private static ExecutorService threadPool = Executors.newFixedThreadPool(5);
    private static CountDownLatch counter = new CountDownLatch(1); 
    
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try {
            Thread A = new Thread(new Runnable() {
                public void run() {
                    System.out.println("逻辑A");
                    counter.countDown();
                }
            });
            A.start();
 
            for (int i=0;i<5;i++){
                //threadPool.submit(new ThreadDemo2("sss"));
            	//测试callable方式   调用产生的的返回值
            	Future future = threadPool.submit(new Caller(100));
            	System.out.println(future.get());
            }
        } finally {
            threadPool.shutdown();
        }
 
    }
 
    static class Caller implements Callable{
        private int param;
        public Caller(int param) {
            this.param = param;
        }
 
        public Object call() throws Exception {
            counter.await();
            System.out.println("逻辑B");
            param = param + new Random().nextInt(20);
            return param;
        }
    } 
}
