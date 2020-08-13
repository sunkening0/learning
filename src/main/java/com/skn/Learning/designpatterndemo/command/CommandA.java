package com.skn.Learning.designpatterndemo.command;

public class CommandA implements Command {

    @Override
    public void execute(CommandReceiver receiver) {
        receiver.doSomethingA();
    }
}

