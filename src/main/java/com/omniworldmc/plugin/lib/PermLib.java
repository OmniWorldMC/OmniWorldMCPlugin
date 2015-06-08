package com.omniworldmc.plugin.lib;

import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;

public class PermLib {

    public static void init(PluginManager pm) {

    }

    public static Permission USE_ENDERBOW = new Permission("om.use.enderbow");
    public static Permission SHOW_DEATH_LOCATION = new Permission("om.showdeathlocation");
    public static Permission CMD_OM = new Permission("om.cmd.om");
}
