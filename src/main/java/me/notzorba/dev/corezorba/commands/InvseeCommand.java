package me.notzorba.dev.corezorba.commands;

import me.gleeming.command.Command;
import me.gleeming.command.paramter.Param;
import me.notzorba.dev.corezorba.utils.CC;
import org.bukkit.entity.Player;

public class InvseeCommand {

    @Command(names = {"invsee", "inventorysee"}, playerOnly = true)
    public static void invseeCommand(Player sender, @Param(name = "target", required = true) Player target) {
        sender.openInventory(target.getInventory());
        sender.sendMessage(CC.format("&eOpening inventory of &d" + target.getDisplayName()));
    }
}
