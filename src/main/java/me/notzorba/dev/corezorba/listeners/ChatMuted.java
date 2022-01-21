package me.notzorba.dev.corezorba.listeners;

import me.notzorba.dev.corezorba.commands.MuteChatCommand;
import me.notzorba.dev.corezorba.utils.CC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatMuted implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("basic.staff")) {
            if (MuteChatCommand.chat_muted) {
                event.setCancelled(true);
                player.sendMessage(CC.format("&eThe chat is currently &dmuted"));
            }
        }
    }
}
