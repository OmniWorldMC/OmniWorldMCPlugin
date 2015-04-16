package com.omniworldmc.plugin.api.chat;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Returns {

    /**
     * Returns the official chat prefix with a green output.
     */
    public static final String CHAT_PREFIX = Color.c("f") + "[" + Color.c("b") + "OmniWorld" + Color.c(6) + "MC" + Color.c("f") + "] " + Color.c("a");

    /**
     * Returns a no perms message that takes arguments.
     */
    public static final String NO_PERMS = CHAT_PREFIX + Color.c("4") + "You do not have permission for " + Color.c("c");

    /**
     * Returns the same as NO_PERMS just using the phrase to use.
     */
    public static final String NO_PERMS_USE = CHAT_PREFIX + Color.c("4") + "You do not have permission to use ";

    /**
     * Formatted USE Return.
     */
    public static final String NO_PERMS_USE_F = CHAT_PREFIX + Color.c("4") + "You do not have permission to use " + Color.c("c");

    /**
     * Returns a fully formated no perms message.
     */
    public static final String NO_PERMS_FULL = CHAT_PREFIX + Color.c("4") + "You do not have permission to do that!";

    /**
     * //TODO add a thing here
     * @param player
     * @param type
     */
    public static void noPermsReturn(Player player, String type) {

        if (type == "cmd") {
            player.sendMessage(NO_PERMS);
            player.playSound(player.getLocation(), Sound.GHAST_FIREBALL, 1, 1);
        } else if (type == "enderBow") {
            player.sendMessage(CHAT_PREFIX + ChatColor.RED + "You do not have permission to use the Ender Bow!");
            player.playSound(player.getLocation(), Sound.GHAST_FIREBALL, 1, 1);
        }
    }
}
