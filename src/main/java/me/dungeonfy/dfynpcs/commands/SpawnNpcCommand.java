package me.dungeonfy.dfynpcs.commands;

import me.dungeonfy.dfynpcs.utils.DfyNpc;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpawnNpcCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§You are not a player silly!");
            return false;
        }

        Player player = (Player) sender;
        Location loc = player.getLocation();

        LivingEntity npc = new DfyNpc(loc)
                .setName("Greg")
                .setType(EntityType.VILLAGER)
                .customizer(e -> {
                    e.setGlowing(true);
                    e.setSilent(true);
                })
                .spawn();

        return true;
    }
}
