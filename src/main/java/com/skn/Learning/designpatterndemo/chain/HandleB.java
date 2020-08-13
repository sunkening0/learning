package com.skn.Learning.designpatterndemo.chain;

public class HandleB extends Handler {

    @Override
    public void execute(Request request) {
        // 处理自己的事，然后交由下一任处理者继续执行请求
        System.out.println("请求处理者B处理请求");
        next.execute(request);
    }
}


