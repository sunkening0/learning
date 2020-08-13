package com.skn.Learning.designpatterndemo.command;

public class CommandReceiverImpl implements CommandReceiver{

    @Override
    public void doSomethingA() {
        System.out.println("命令执行者方法A");
    }

    @Override
    public void doSomethingB() {
        System.out.println("命令执行者方法B");
    }
}

