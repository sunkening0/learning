package com.skn.Learning.designpatterndemo.chain;

public class ActualHandler extends Handler {

    @Override
    public void execute(Request request) {
        // 直接执行请求
        request.doSomething();
    }

}

