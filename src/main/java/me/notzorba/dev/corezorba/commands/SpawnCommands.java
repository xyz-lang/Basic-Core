package me.notzorba.dev.corezorba.commands;

import me.gleeming.command.Command;
import me.notzorba.dev.corezorba.Core;
import me.notzorba.dev.corezorba.utils.CC;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class SpawnCommands {

    @Command(names = {"setspawn", "setworldspawn"}, permission = "basic.admin", playerOnly = true)
    public static void setspawnCommand(Player sender) {

        Location location = sender.getLocation();

        Core.getInstance().getConfig().set("spawn", location);
        Core.getInstance().saveConfig();
        sender.sendMessage(CC.format("&eSpawn location successfully &dupdated"));
    }

    @Command(names = {"spawn", "gospawn"}, playerOnly = true)
    public static void spawnCommand(Player sender) {

        Location location = Core.getInstance().getConfig().getLocation("spawn");

        if(location != null) {
            sender.teleport(location);
            sender.sendMessage(CC.format("&eYou have been teleported to &dspawn"));
        }else{
            sender.sendMessage(CC.format("&eThe &dspawn &eis not set please contact and &dAdmin"));
        }
    }
}
