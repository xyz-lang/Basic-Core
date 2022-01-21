package me.notzorba.dev.corezorba.commands;

import me.gleeming.command.Command;
import me.gleeming.command.paramter.Param;
import me.notzorba.dev.corezorba.utils.CC;
import org.bukkit.entity.Player;

public class TeleportCommands {

    @Command(names = {"tp", "teleport"}, permission = "basic.tp", playerOnly = true)
    public static void tpCommand(Player sender, @Param(name = "target", required = true) Player target, @Param(name = "target", required = false) Player player) {
        if(player != null){
            target.teleport(player.getLocation());
            target.sendMessage(CC.format("&eYou have been teleported to &d" + player.getDisplayName()));
            sender.sendMessage(CC.format("&eYou have teleported &d" + target.getDisplayName() + " &eto &d" + player.getDisplayName()));
        }else{
            sender.teleport(target.getLocation());
            sender.sendMessage(CC.format("&eYou have been teleported to &d" + target.getDisplayName()));
        }
    }

    @Command(names = {"tphere", "teleporthere"}, permission = "basic.tphere", playerOnly = true)
    public static void tphereCommand(Player sender, @Param(name = "target", required = true) Player target) {
        target.teleport(sender.getLocation());
        target.sendMessage(CC.format("&eYou have been teleported to &d" + sender.getDisplayName()));
        sender.sendMessage(CC.format("&eYou have teleported &d" + target.getDisplayName() + " &eto &dyour location"));
    }
}