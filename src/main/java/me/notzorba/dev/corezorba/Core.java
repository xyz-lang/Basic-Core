package me.notzorba.dev.corezorba;

import lombok.Getter;
import lombok.Setter;
import me.gleeming.command.CommandHandler;
import me.notzorba.dev.corezorba.listeners.ChatMuted;
import org.bukkit.plugin.java.JavaPlugin;

public final class Core extends JavaPlugin {

    @Getter @Setter private static Core instance;

    @Override
    public void onEnable() {

        saveConfig();
        saveDefaultConfig();
        setInstance(this);
        CommandHandler.registerCommands("me.notzorba.dev.corezorba.commands", this);
        this.getServer().getPluginManager().registerEvents(new ChatMuted(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
