package me.notzorba.dev.corezorba.commands;

import me.gleeming.command.Command;
import me.gleeming.command.paramter.Param;
import me.notzorba.dev.corezorba.Core;
import me.notzorba.dev.corezorba.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import redis.clients.jedis.commands.ClientCommands;
import redis.clients.jedis.util.Pool;

import java.util.Base64;
import java.util.HashMap;


public class StaffCommands {

    public static HashMap<String, Long> cooldowns = new HashMap<String, Long>();

    @Command(names = {"staffchat", "sc"}, permission = "basic.staff")
    public static void staffchatCommand(Player sender, @Param(name = "text", concated = true, required = true) String message) {

        Bukkit.getOnlinePlayers().stream()
                .filter(player -> player.hasPermission("basic.staff"))
                .forEach(player -> player.sendMessage(CC.format("&9[Staff] &7[" + Core.getInstance().getConfig().getString("server.name") + "&7] &e" + sender.getDisplayName() + "&7: &b" + message)));
    }

    @Command(names = {"adminchat", "ac"}, permission = "basic.admin")
    public static void adminchatCommand(Player sender, @Param(name = "text", concated = true, required = true) String message) {

        Bukkit.getOnlinePlayers().stream()
                .filter(player -> player.hasPermission("basic.admin"))
                .forEach(player -> player.sendMessage(CC.format("&c[Admin] &7[" + Core.getInstance().getConfig().getString("server.name") + "&7] &e" + sender.getDisplayName() + "&7: &c" + message)));
    }

    @Command(names = {"report", "cheating", "hacker", "rulebreaker"})
    public static void reportCommand(Player sender, @Param(name = "target", required = true) Player target, @Param(name = "reason", concated = true, required = true) String message) {

        int cooldownTime = 60;

        if (cooldowns.containsKey(sender.getName())) {
            long secondsLeft = ((cooldowns.get(sender.getName()) / 1000) + cooldownTime) - (System.currentTimeMillis() / 1000);
            if (secondsLeft > 0) {
                sender.sendMessage(CC.format("&eYou are still on cooldown for &d" + String.valueOf(secondsLeft) + "&e seconds"));
            }
        }else {
            Bukkit.getOnlinePlayers().stream()
                    .filter(player -> player.hasPermission("basic.staff"))
                    .forEach(player -> player.sendMessage(CC.format("&9[Report] &7[" + Core.getInstance().getConfig().getString("server.name") + "&7] &e" + sender.getDisplayName() + "&7 has reported &e" + target.getDisplayName() + "\n" + "    &9Reason: &7" + message)));
            sender.sendMessage(CC.format("&eReport has been sent to all &donline staff"));
            cooldowns.put(sender.getName(), System.currentTimeMillis());
        }
    }
}