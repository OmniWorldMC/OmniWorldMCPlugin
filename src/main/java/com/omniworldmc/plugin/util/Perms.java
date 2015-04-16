package com.omniworldmc.plugin.util;

import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;

public class Perms {

    public static void init() {
        PluginManager pm = Bukkit.getServer().getPluginManager();

        pm.addPermission(OM);
        pm.addPermission(OM_HELP);
        pm.addPermission(OM_RELOAD);
        pm.addPermission(RAGE);
        pm.addPermission(USE_ENDERBOW);
    }

    public static Permission OM = new Permission("om.cmd.om");
    public static Permission OM_HELP = new Permission("om.cmd.om.help");
    public static Permission OM_RELOAD = new Permission("om.cmd.om.reload");
    public static Permission RAGE = new Permission("om.cmd.rage");
    public static Permission USE_ENDERBOW = new Permission("om.use.enderbow");
}
