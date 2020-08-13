package com.skn.Learning.designpatterndemo.command;

/**
 * 命令模式
 */
public interface Command {

    void execute(CommandReceiver receiver);
}

