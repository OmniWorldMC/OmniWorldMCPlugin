package com.omniworldmc.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public class OmniWorldMC extends JavaPlugin {

    @Override
    public void onEnable() {

        getLogger().info("Enabled");
    }
    @Override
    public void onDisable() {

        getLogger().info("Disabled");
    }
}
