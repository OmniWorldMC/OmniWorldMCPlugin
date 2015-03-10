package com.omniworldmc.plugin;

import com.omniworldmc.plugin.commands.CMDHealME;
import com.omniworldmc.plugin.commands.CMDOM;
import com.omniworldmc.plugin.commands.CMDRage;
import com.omniworldmc.plugin.util.Permissions;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

import java.io.IOException;

public class OmniWorldMC extends JavaPlugin {

    @Override
    public void onEnable() {

        PluginManager pm = getServer().getPluginManager();

        //Metrics
        try {
            Metrics metrics = new Metrics(this);
            metrics.start();
        } catch (IOException e) {
            e.printStackTrace();
            getLogger().severe("Failed To Submit Metrics, Tell Chris about this.");
        }

        //Register CMD's
        this.getCommand("om").setExecutor(new CMDOM(this));
        this.getCommand("rage").setExecutor(new CMDRage(this));
        this.getCommand("healme").setExecutor(new CMDHealME(this));

        //Register Listeners


        //Register Permissions
        pm.addPermission(Permissions.omOm);
        pm.addPermission(Permissions.omRage);
        pm.addPermission(Permissions.omHealMe);

        getLogger().info("Enabled");
    }
    @Override
    public void onDisable() {

        getLogger().info("Disabled");
    }
}
