package me.notzorba.dev.corezorba.commands;

import me.gleeming.command.Command;
import me.gleeming.command.paramter.Param;
import me.notzorba.dev.corezorba.utils.CC;
import org.bukkit.entity.Player;

public class ClearCommand {

    @Command(names = {"ci", "clear"}, permission = "basic.clear", playerOnly = true)
    public static void clearCommand(Player sender, @Param(name = "target", required = false) Player target) {
        if(target != null) {
            if (target.hasPermission("basic.clear.other")) {
                target.getInventory().clear();
                target.sendMessage(CC.format("&eYour inventory has been cleared"));
                sender.sendMessage(CC.format("&eYou have cleared &d" + target.getDisplayName() + "&d's &einventory"));
            }else{
                sender.sendMessage(CC.format("&cNo permission!"));
            }
        }else{
            sender.getInventory().clear();
            sender.sendMessage(CC.format("&eYour inventory has been cleared"));
        }
    }
}
