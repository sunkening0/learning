package com.skn.Learning.designpatterndemo.command;

/**
 * 命令执行者
 */
public class CommandExecutor {

    public void execute(Command command) {
        command.execute(new CommandReceiverImpl());
    }
}

