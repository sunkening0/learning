package com.skn.Learning.designpatterndemo.command;

public class CommandB implements Command {

    @Override
    public void execute(CommandReceiver receiver) {
        receiver.doSomethingB();
    }
}

