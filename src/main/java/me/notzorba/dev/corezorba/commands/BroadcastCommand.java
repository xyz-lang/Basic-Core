package me.notzorba.dev.corezorba.commands;

import me.gleeming.command.Command;
import me.gleeming.command.paramter.Param;
import me.notzorba.dev.corezorba.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BroadcastCommand {

    @Command(names = {"broadcast", "bc"}, permission = "basic.broadcast")
    public static void broadcastCommand(Player sender, @Param(name = "text", concated = true, required = true) String message) {
        Bukkit.broadcastMessage(CC.format("&6&l[&e&lAlert&6&l] &e" + message));
    }

}
