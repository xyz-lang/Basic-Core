package me.notzorba.dev.corezorba.listeners;

import me.notzorba.dev.corezorba.Core;
import me.notzorba.dev.corezorba.utils.CC;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnListeners implements Listener {

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        if(!player.hasPlayedBefore()) {

            Location location = Core.getInstance().getConfig().getLocation("spawn");

            player.teleport(location);
            e.setJoinMessage(CC.format("&7[&e+&7] &e" + player.getDisplayName() + "&7 has joined for the first time!"));
        }else {
            e.setJoinMessage(CC.format("&7[&e+&7] &e" + player.getDisplayName()));
        }
    }
    @EventHandler
    public static void onRespawn(PlayerRespawnEvent e) {

        Player player = e.getPlayer();
        Location location = Core.getInstance().getConfig().getLocation("spawn");

        e.setRespawnLocation(location);
    }
}
