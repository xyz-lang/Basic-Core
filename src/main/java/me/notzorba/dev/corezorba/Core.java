package me.notzorba.dev.corezorba;

import lombok.Getter;
import lombok.Setter;
import me.gleeming.command.CommandHandler;
import me.notzorba.dev.corezorba.listeners.ChatMuted;
import me.notzorba.dev.corezorba.listeners.SpawnListeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class Core extends JavaPlugin {

    @Getter @Setter private static Core instance;

    @Override
    public void onEnable() {

        //Config.yml
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        saveConfig();

        //Command & Event Register
        setInstance(this);
        CommandHandler.registerCommands("me.notzorba.dev.corezorba.commands", this);
        this.getServer().getPluginManager().registerEvents(new ChatMuted(), this);
        this.getServer().getPluginManager().registerEvents(new SpawnListeners(), this);
    }
    @Override
    public void onDisable() {
        //Config.yml
        saveConfig();
    }
}
