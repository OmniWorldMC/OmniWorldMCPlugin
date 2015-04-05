package com.omniworldmc.plugin.util;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Info {
    public static final String CHAT_PREFIX = ChatColor.WHITE + "[" + ChatColor.AQUA + "OmniWorld" + ChatColor.GOLD + "MC" + ChatColor.WHITE + "] " + ChatColor.GREEN;
    public static final String NO_PERMS = CHAT_PREFIX + ChatColor.RED + "You do not have permission to use that command!";

    public static void noPerms(Player player, String type) {
        if (type == "cmd") {
            player.sendMessage(NO_PERMS);
            player.playSound(player.getLocation(), Sound.GHAST_FIREBALL, 1, 1);
        } else if (type == "enderBow") {
            player.sendMessage(CHAT_PREFIX + ChatColor.RED + "You do not have permission to use the Ender Bow!");
            player.playSound(player.getLocation(), Sound.GHAST_FIREBALL, 1, 1);
        }
    }
}
