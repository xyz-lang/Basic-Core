package me.notzorba.dev.corezorba.commands;

import me.gleeming.command.Command;
import me.gleeming.command.paramter.Param;
import me.notzorba.dev.corezorba.utils.CC;
import org.bukkit.entity.Player;

public class HealCommand {

    @Command(names = {"heal", "hearts"}, permission = "basic.heal", playerOnly = true)
    public static void healCommand(Player sender, @Param(name = "target", required = false) Player target) {
        if(target != null){
            target.setHealth(20);
            target.setFoodLevel(100);
            target.setFireTicks(0);
            target.sendMessage(CC.format("&eYou have been healed"));
            sender.sendMessage(CC.format("&eYou have healed &d" + target.getDisplayName()));
        }else{
            sender.setHealth(20);
            sender.setFoodLevel(100);
            sender.setFireTicks(0);
            sender.sendMessage(CC.format("&eYou have been healed"));
        }
    }
}
