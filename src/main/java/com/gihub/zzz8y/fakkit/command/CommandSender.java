package com.gihub.zzz8y.fakkit.command;

import net.minecraft.server.command.ServerCommandSource;

public class CommandSender {
    private final CommandSenderEnum senderType;
    private final ServerCommandSource source;

    public CommandSender(CommandSenderEnum senderType, ServerCommandSource source) {
        this.senderType = senderType;
        this.source = source;
    }

    public CommandSenderEnum getSenderType() {
        return senderType;
    }

    public ServerCommandSource getSource() {
        return source;
    }
}
