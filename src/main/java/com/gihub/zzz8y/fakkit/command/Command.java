package com.gihub.zzz8y.fakkit.command;

public abstract class Command {
    private String command;
    private int argAmount;

    /**
     * 构造方法设定命令
     * @param command 命令
     */
    protected Command(String command) {
        this.command = command;
    }

    /**
     * 执行方法
     * @param sender 命令发送者
     * @param command 命令
     * @param args 命令参数
     * @return 命令是否正确执行
     */
    public abstract boolean execute(CommandSender sender,String command,String[] args);

    public String getCommand() {
        return command;
    }

    /**
     * 设置mod中显示的args个数，默认为20
     * 需要更多arg时可以重写此方法
     * @return args个数
     */
    public int getArgAmount() {
        return 21;
    }
}
