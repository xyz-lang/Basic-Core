package me.notzorba.dev.corezorba;

import lombok.Getter;
import lombok.Setter;
import me.gleeming.command.CommandHandler;
import me.notzorba.dev.corezorba.listeners.ChatMuted;
import me.notzorba.dev.corezorba.listeners.SpawnListeners;
import me.notzorba.dev.corezorba.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


public final class Core extends JavaPlugin {

    public static JedisPool pool;

    @Getter @Setter private static Core instance;

    @Override
    public void onEnable() {

        //Config.yml
        getConfig().options().copyDefaults();

        //Command & Event Register
        setInstance(this);
        CommandHandler.registerCommands("me.notzorba.dev.corezorba.commands", this);
        this.getServer().getPluginManager().registerEvents(new ChatMuted(), this);
        this.getServer().getPluginManager().registerEvents(new SpawnListeners(), this);

        //Jedis
        pool = new JedisPool("redis-18488.c10.us-east-1-2.ec2.cloud.redislabs.com:18488");
        Jedis j = null;
        try {
            j = pool.getResource();
            j.auth("JEHysjdkwU*");
            Bukkit.getConsoleSender().sendMessage(CC.format("&7&m-------------------------------"));
            Bukkit.getConsoleSender().sendMessage(CC.format(""));
            Bukkit.getConsoleSender().sendMessage(CC.format("&b&oCoreV1.0"));
            Bukkit.getConsoleSender().sendMessage(CC.format(""));
            Bukkit.getConsoleSender().sendMessage(CC.format("&cRedis: &aEnabled & Connected"));
            Bukkit.getConsoleSender().sendMessage(CC.format("&aMongo: &cDisabled"));
            Bukkit.getConsoleSender().sendMessage(CC.format(""));
            Bukkit.getConsoleSender().sendMessage(CC.format("&7&m-------------------------------"));
        } finally {
            j.close();
        }
    }

    @Override
    public void onDisable() {
        pool.close();
    }
}
