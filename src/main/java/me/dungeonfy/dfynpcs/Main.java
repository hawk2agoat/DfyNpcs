package me.dungeonfy.dfynpcs;

import me.dungeonfy.dfynpcs.commands.SpawnNpcCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onLoad() {
        getLogger().info("Npcs Loaded");
        getLogger().warning("Could be bad");
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        getCommand("spawnNpc").setExecutor(new SpawnNpcCommand());

    }

    @Override
    public void onDisable() {
        getLogger().info("Goodnight o7");
    }
}
