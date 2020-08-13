package com.skn.Learning.designpatterndemo.chain;

/**
 * 责任链模式
 */
public abstract class Handler {
    protected Handler next;

    public void setNext(Handler handler) {
        this.next = handler;
    }


    // 处理请求的方法，交由子类实现
    public abstract void execute(Request request);

}


