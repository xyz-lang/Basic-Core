package me.notzorba.dev.corezorba.commands;

import me.gleeming.command.Command;
import me.notzorba.dev.corezorba.Core;
import org.bukkit.command.CommandSender;

public class ReloadCommand {

    @Command(names = {"corereload", "reloadcore"}, permission = "core.reload", playerOnly = false)
    public static void reloadCommand(CommandSender sender) {
        Core.getInstance().reloadConfig();
    }
}
