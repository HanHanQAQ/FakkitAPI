package com.gihub.zzz8y.fakkit.command;

import com.gihub.zzz8y.fakkit.command.exceptions.RegSameCommandException;
import com.gihub.zzz8y.fakkit.utils.command.CommandUtil;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.ServerCommandSource;

import java.util.ArrayList;

public class CommandManager {
    private final ArrayList<Command> commands;

    public CommandManager() {
        commands = new ArrayList<>();
    }

    /**
     * 注册命令
     * 你可以在任何地方注册命令，但同样的命令只能有一个
     * @param command 命令实例
     */
    public void register(Command command) {
        commands.forEach(cmd -> {
            if (cmd.getCommand().equalsIgnoreCase(command.getCommand())) {
                throw new RegSameCommandException();
            }
        });
        commands.add(command);

        ArrayList<String> args = new ArrayList<>();
        CommandRegistrationCallback.EVENT.register(
                (dispatcher, registryAccess, environment) ->
                {
                    dispatcher.register(getCommandBuilder(command,command.getArgAmount()));
                });


    }

    public static LiteralArgumentBuilder<ServerCommandSource> getCommandBuilder(Command command, int argIndex) {
        LiteralArgumentBuilder<ServerCommandSource> builder = net.minecraft.server.command.CommandManager.literal(command.getCommand()).executes(context -> {
            ArrayList<String> args = new ArrayList<>();
            for (String arg : context.getInput().split(" ")) {
                if (arg.equalsIgnoreCase(command.getCommand())) {
                    continue;
                }
                args.add(arg);
            }
            command.execute(new CommandSender(CommandUtil.getSenderType(context.getSource()),context.getSource()),command.getCommand(),args.toArray(new String[0]));
            return 1;
        });

        ArrayList<RequiredArgumentBuilder<ServerCommandSource, String>> requiredArgumentBuilders = new ArrayList<>();
        for (int i = 0; i < argIndex; i++) {
            if (requiredArgumentBuilders.isEmpty()) {
                buildStringArgument(command, requiredArgumentBuilders);
                continue;
            }
            buildStringArgument(command, requiredArgumentBuilders);
            requiredArgumentBuilders.get(i).then(requiredArgumentBuilders.get(i-1));
        }
        builder.then(requiredArgumentBuilders.getLast());
        return builder;
    }

    private static void buildStringArgument(Command command, ArrayList<RequiredArgumentBuilder<ServerCommandSource, String>> requiredArgumentBuilders) {
        requiredArgumentBuilders.add(net.minecraft.server.command.CommandManager.argument("arg", StringArgumentType.string()).executes(context -> {
            ArrayList<String> args = new ArrayList<>();
            for (String arg : context.getInput().split(" ")) {
                if (arg.equalsIgnoreCase(command.getCommand())) {
                    continue;
                }
                args.add(arg);
            }
            command.execute(new CommandSender(CommandUtil.getSenderType(context.getSource()),context.getSource()),command.getCommand(),args.toArray(new String[0]));
            return 1;
        }));
    }

    public ArrayList<Command> getCommands() {
        return commands;
    }
}
