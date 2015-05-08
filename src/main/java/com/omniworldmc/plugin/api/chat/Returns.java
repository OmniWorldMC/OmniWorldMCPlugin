package com.omniworldmc.plugin.api.chat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Returns {

    /**
     * Returns the official chat prefix with a green output.
     */
    public static final String CHAT_PREFIX = ChatColor.WHITE + "[" + ChatColor.AQUA + "OmniWorld" + ChatColor.GOLD + "MC" + ChatColor.WHITE + "] " + ChatColor.GREEN;

    /**
     * No permission message.
     */
    public static final String NO_PERMS = CHAT_PREFIX + ChatColor.RED + "You do not have permission for that command.";

    /**
     * Ender Bow No Perms.
     */
    public static final String NO_PERMS_ENDER_BOW = CHAT_PREFIX + ChatColor.RED + "You do not have permission to use the Ender Bow.";

    public static void deathLocMessage(Player player, int x, int y, int z, String world) {
        player.sendMessage(CHAT_PREFIX + "You have died at, X: " + ChatColor.DARK_AQUA + x + ChatColor.GREEN +  ", Y: " + ChatColor.DARK_AQUA + y + ChatColor.GREEN + ", Z: " + ChatColor.DARK_AQUA + z + ChatColor.GREEN + ", In world, " + ChatColor.DARK_AQUA + world + ChatColor.GREEN + ".");
    }
}
