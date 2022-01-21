package me.notzorba.dev.corezorba.commands;

import me.gleeming.command.Command;
import me.notzorba.dev.corezorba.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MuteChatCommand {

    public static boolean chat_muted = false;

    @Command(names = {"mutechat", "mc"}, permission = "basic.staff")
    public static void mutechatCommand(Player sender) {
        if (chat_muted) {
            chat_muted = false;
            Bukkit.broadcastMessage(CC.format("&eChat has been &dunmuted"));
        } else {
            chat_muted = true;
            Bukkit.broadcastMessage(CC.format("&eChat has been &dmuted"));
        }
    }
}