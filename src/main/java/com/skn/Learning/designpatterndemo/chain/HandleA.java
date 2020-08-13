package com.skn.Learning.designpatterndemo.chain;

public class HandleA extends Handler {

    @Override
    public void execute(Request request) {
        // 处理自己的事，然后交由下一任处理者继续执行请求
        System.out.println("请求处理者A处理请求");
        next.execute(request);
    }
}
