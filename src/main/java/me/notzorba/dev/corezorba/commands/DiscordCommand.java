package me.notzorba.dev.corezorba.commands;

import me.gleeming.command.Command;
import me.notzorba.dev.corezorba.Core;
import me.notzorba.dev.corezorba.utils.CC;
import org.bukkit.entity.Player;

public class DiscordCommand {

    @Command(names = {"discord", "dc"})
    public static void discordCommand(Player sender) {
        sender.sendMessage(CC.format("&eDiscord: &d" + Core.getInstance().getConfig().getString("server.discord")));
    }
}
