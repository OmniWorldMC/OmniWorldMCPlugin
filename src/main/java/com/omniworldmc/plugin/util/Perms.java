package com.omniworldmc.plugin.util;

import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;

public class Perms {

    public static void init() {
        PluginManager pm = Bukkit.getServer().getPluginManager();

        pm.addPermission(OM_SHOW_DEATH_LOC);
        pm.addPermission(OM_USE_VEIN_MINER);
        pm.addPermission(USE_ENDERBOW);
    }

    public static Permission OM_SHOW_DEATH_LOC = new Permission("om.showdeathlocation");
    public static Permission OM_USE_VEIN_MINER = new Permission("om.use.veinminer");
    public static Permission USE_ENDERBOW = new Permission("om.use.enderbow");
}
