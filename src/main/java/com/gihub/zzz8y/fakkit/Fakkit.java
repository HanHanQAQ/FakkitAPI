package com.gihub.zzz8y.fakkit;

import com.gihub.zzz8y.fakkit.command.CommandManager;

public class Fakkit {
    public static boolean init = false;
    private static final CommandManager commandManager = new CommandManager();

    public static boolean init() {
        init = true;
        return true;
    }
    public static CommandManager getCommmandManager() {
        return commandManager;
    }
}

