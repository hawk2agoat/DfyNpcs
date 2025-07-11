package me.dungeonfy.dfynpcs.utils;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Consumer;

public class DfyNpc {
    private final Location loc;
    private String name;
    private EntityType type;
    //private boolean sentient = false;
    //private boolean invulnerable = false;
    private Consumer<LivingEntity> customizer;

    public DfyNpc(Location loc) {
        this.loc = loc;
    }

    public DfyNpc setName(String name) {
        this.name = name;
        return this;
    }

    public DfyNpc setType(EntityType type) {
        this.type = type;
        return this;
    }

    /*public DfyNpc setSentience(Boolean sentience) {
        this.sentient = sentience;
        return this;
    }

    public DfyNpc setInvulnerability(Boolean invulnerable) {
        this.invulnerable = invulnerable;
        return this;
    }*/

    public DfyNpc customizer(Consumer<LivingEntity> consumer) {
        this.customizer = consumer;
        return this;
    }

    public LivingEntity spawn() {
        LivingEntity entity = (LivingEntity) loc.getWorld().spawnEntity(loc, type);
        if (name != null) {
            entity.setCustomName(name);
            entity.setCustomNameVisible(true);
        }
        entity.setAI(false);
        entity.setInvulnerable(true);
        entity.setPersistent(true);
        entity.setCanPickupItems(false);
        return entity;
    }
}
