package me.notzorba.dev.corezorba.commands;

import me.gleeming.command.Command;
import me.gleeming.command.paramter.Param;
import me.notzorba.dev.corezorba.utils.CC;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class GamemodeCommands {

    @Command(names = {"gmc", "gamemode c", "gamemode creative"}, permission = "basic.gamemode", playerOnly = true)
    public static void gmcCommand(Player sender, @Param(name = "target", required = false) Player target) {
        if(target != null){
            if(sender.hasPermission("basic.gamemode.other")) {
                target.setGameMode(GameMode.CREATIVE);
                target.sendMessage(CC.format("&eYour game mode was set to &dCreative"));
                sender.sendMessage(CC.format("&eYou have set &d" + target.getDisplayName() + "&e to &dCreative&e mode"));
            }else{
                sender.sendMessage(CC.format("&cNo permission!"));
            }
        }else{
            sender.setGameMode(GameMode.CREATIVE);
            sender.sendMessage(CC.format("&eYour game mode was set to &dCreative"));
        }
    }

    @Command(names = {"gms", "gamemode s", "gamemode survival"}, permission = "basic.gamemode", playerOnly = true)
    public static void gmsCommand(Player sender, @Param(name = "target", required = false) Player target) {
        if(target != null){
            if(sender.hasPermission("basic.gamemode.other")) {
                target.setGameMode(GameMode.SURVIVAL);
                target.sendMessage(CC.format("&eYour game mode was set to &dSurvival"));
                sender.sendMessage(CC.format("&eYou have set &d" + target.getDisplayName() + "&e to &dSurvival&e mode"));
            }else{
                sender.sendMessage(CC.format("&cNo permission!"));
            }
        }else{
            sender.setGameMode(GameMode.SURVIVAL);
            sender.sendMessage(CC.format("&eYour game mode was set to &dSurvival"));
        }
    }

    @Command(names = {"gmsp", "gamemode sp", "gamemode spectator"}, permission = "basic.gamemode", playerOnly = true)
    public static void gmspCommand(Player sender, @Param(name = "target", required = false) Player target) {
        if(target != null){
            if(sender.hasPermission("basic.gamemode.other")) {
                target.setGameMode(GameMode.SPECTATOR);
                target.sendMessage(CC.format("&eYour game mode was set to &dSpectator"));
                sender.sendMessage(CC.format("&eYou have set &d" + target.getDisplayName() + "&e to &dSpectator&e mode"));
            }else{
                sender.sendMessage(CC.format("&cNo permission!"));
            }
        }else{
            sender.setGameMode(GameMode.SPECTATOR);
            sender.sendMessage(CC.format("&eYour game mode was set to &dSpectator"));
        }
    }

    @Command(names = {"gma", "gamemode a", "gamemode adventure"}, permission = "basic.gamemode", playerOnly = true)
    public static void gmaCommand(Player sender, @Param(name = "target") Player target) {
        if(target != null){
            if(sender.hasPermission("basic.gamemode.other")) {
                target.setGameMode(GameMode.ADVENTURE);
                target.sendMessage(CC.format("&eYour game mode was set to &dAdventure"));
                sender.sendMessage(CC.format("&eYou have set &d" + target.getDisplayName() + "&e to &dAdventure&e mode"));
            }else{
                sender.sendMessage(CC.format("&cNo permission!"));
            }
        }else{
            sender.setGameMode(GameMode.ADVENTURE);
            sender.sendMessage(CC.format("&eYour game mode was set to &dAdventure"));
        }
    }
}
