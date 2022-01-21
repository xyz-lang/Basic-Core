package me.notzorba.dev.corezorba.commands;

import me.gleeming.command.Command;
import me.notzorba.dev.corezorba.Core;
import me.notzorba.dev.corezorba.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ClearChatCommand {

    @Command(names = {"clearchat", "cc"}, permission = "basic.staff")
    public static void clearchatCommand(Player sender){
        for (int x = 0; x < 1001; x++){
            Bukkit.broadcastMessage("");
        }
        Bukkit.broadcastMessage(CC.format("&eChat has been &dcleared"));
    }
}
