package me.notzorba.dev.corezorba.commands;

import me.gleeming.command.Command;
import me.gleeming.command.paramter.Param;
import me.notzorba.dev.corezorba.utils.CC;
import org.bukkit.entity.Player;

public class PingCommand {

    @Command(names = {"ping", "ms"}, playerOnly = true)
    public static void pingCommand(Player sender, @Param(name = "target", required = false) Player target) {
        if(target != null){
            sender.sendMessage(CC.format("&d" + target.getDisplayName() + "&d's &eping: &a" + target.getPing()));
        }else{
            sender.sendMessage(CC.format("&eYour ping: &a" + sender.getPing()));
        }
    }
}
