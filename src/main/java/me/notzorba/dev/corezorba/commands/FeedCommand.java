package me.notzorba.dev.corezorba.commands;

import me.gleeming.command.Command;
import me.gleeming.command.paramter.Param;
import me.notzorba.dev.corezorba.utils.CC;
import org.bukkit.entity.Player;

public class FeedCommand {

    @Command(names = {"feed", "eat"}, permission = "basic.feed", playerOnly = true)
    public static void feedCommand(Player sender, @Param(name = "target", required = false) Player target) {
        if(target != null){
            if(sender.hasPermission("basic.feed.other")){
                target.setFoodLevel(100);
                target.sendMessage(CC.format("&eYou have been fed"));
                sender.sendMessage(CC.format("&eYou have fed &d" + target.getDisplayName()));
            }else{
                sender.sendMessage(CC.format("No permission!"));
            }
        }else{
            sender.setFoodLevel(100);
            sender.sendMessage(CC.format("&eYou have been fed"));
        }
    }
}
