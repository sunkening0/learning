package com.skn.Learning.threaddemo;

public class ThreadDemo10{

    public static void main(String[] args) throws InterruptedException {
        Resource3 r3 = new Resource3();

        Runnable aDemo2 = new Thread2(r3);
        Thread bThread = new Thread(aDemo2);
        bThread.start();

        Thread.sleep(1000);

        Thread1 aDemo1 = new Thread1(r3);
        Thread aThread = new Thread(aDemo1);
        aThread.start();




    }


}

class Resource3{
    public static Integer a = 0;
    public Integer getA(){
        return a;
    }
    public void setA(Integer a1){
        a = a1;
    }
}

class Thread1 implements Runnable {
    public Resource3 r;
    public Thread1(Resource3 r1){
        r = r1;
    }

    @Override
    public void run() {
        test1();
    }

    public synchronized void test1(){
        while(true){
            if(r.getA()==1){
                System.out.println(r.getA());
            }
        }
    }
}

class Thread2 implements Runnable {
    Resource3 a;
    public Thread2(Resource3 r){
        a = r;
    }
    @Override
    public void run() {
        a.setA(1);
    }
}
