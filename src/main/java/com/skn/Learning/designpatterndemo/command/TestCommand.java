package com.skn.Learning.designpatterndemo.command;

public class TestCommand {
    public static void main(String[] args) {
        // 创建命令执行者
        CommandExecutor commandExecutor = new CommandExecutor();
        // 创建命令A，交由命令执行者执行
        Command commandA = new CommandA();
        commandExecutor.execute(commandA);

        // 创建命令B，交由命令执行者执行
        Command commandB = new CommandB();
        commandExecutor.execute(commandB);
    }

}
