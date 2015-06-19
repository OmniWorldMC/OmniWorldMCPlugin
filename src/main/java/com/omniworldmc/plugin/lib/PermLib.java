package com.omniworldmc.plugin.lib;

import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;

public class PermLib {

    public static void init(PluginManager pm) {
        pm.addPermission(USE_ENDERBOW);
        pm.addPermission(SHOW_DEATH_LOCATION);
        pm.addPermission(CMD_OM);
        pm.addPermission(DP_HD);
        pm.addPermission(DP_CRAFT_DIAMOND_HAMMER);
        pm.addPermission(DP_CRAFT_DIAMOND_EXCAVATOR);
        pm.addPermission(DP_USE_DIAMOND_HAMMER);
        pm.addPermission(DP_USE_DIAMOND_EXCAVATOR);
        pm.addPermission(DP_ENCHANT_DIAMOND_HAMMER);
        pm.addPermission(DP_ENCHANT_DIAMOND_EXCAVATOR);
    }

    public static Permission USE_ENDERBOW = new Permission("om.use.enderbow");
    public static Permission SHOW_DEATH_LOCATION = new Permission("om.showdeathlocation");
    public static Permission CMD_OM = new Permission("om.cmd.om");
    public static Permission DP_HD = new Permission("om.dp.hd");
    public static Permission DP_CRAFT_DIAMOND_HAMMER = new Permission("om.craft.hammer.diamond");
    public static Permission DP_CRAFT_DIAMOND_EXCAVATOR = new Permission("om.craft.excavator.diamond");
    public static Permission DP_USE_DIAMOND_HAMMER = new Permission("om.use.hammer.diamond");
    public static Permission DP_USE_DIAMOND_EXCAVATOR = new Permission("om.use.excavator.diamond");
    public static Permission DP_ENCHANT_DIAMOND_HAMMER = new Permission("om.enchant.hammer.diamond");
    public static Permission DP_ENCHANT_DIAMOND_EXCAVATOR = new Permission("om.enchant.excavator.diamond");
}
