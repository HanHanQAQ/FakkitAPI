package com.gihub.zzz8y.fakkit.utils.command;

import com.gihub.zzz8y.fakkit.command.CommandSenderEnum;
import net.minecraft.entity.vehicle.CommandBlockMinecartEntity;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;

public class CommandUtil {
    public static CommandSenderEnum getSenderType(ServerCommandSource source) {
        if (source.getEntity() == null) {
            //控制台或者命令方块
            return CommandSenderEnum.CONSOLE_OR_COMMAND_BLOCK;
        } else if (source.getEntity() instanceof ServerPlayerEntity) {
            // 命令来自玩家
            return CommandSenderEnum.PLAYER;
        } else if (source.getEntity() instanceof CommandBlockMinecartEntity) {
            // 命令来自命令方块矿车
            return CommandSenderEnum.COMMAND_BLCOK_MINECART;
        } else {
            // 可能是其他实体执行的命令
            return CommandSenderEnum.OTHER_ENTITY;
        }
    }
}
