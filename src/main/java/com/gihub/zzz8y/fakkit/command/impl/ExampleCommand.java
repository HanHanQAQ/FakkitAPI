package com.gihub.zzz8y.fakkit.command.impl;

import com.gihub.zzz8y.fakkit.command.Command;
import com.gihub.zzz8y.fakkit.command.CommandSender;
import net.minecraft.text.Text;

import java.util.Arrays;

public class ExampleCommand extends Command {
    public ExampleCommand() {
        super("example");
    }

    @Override
    public boolean execute(CommandSender sender, String command, String[] args) {
        sender.getSource().sendMessage(Text.literal("你好我是由基于Fabric的Fakkit框架创建的测试指令！"));
        sender.getSource().sendMessage(Text.literal("我的参数有：" + Arrays.toString(args)));
        return false;
    }
}
