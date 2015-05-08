package com.omniworldmc.plugin.api.chat;

import org.bukkit.entity.Player;

public class Returns {

    /**
     * Returns the official chat prefix with a green output.
     */
    public static final String CHAT_PREFIX = Color.c(6) + "[" + Color.c(2) + "OmniWorld" + Color.c(6) + "MC" + Color.c(6) + "] " + Color.c(1);

    /**
     * No permission message.
     */
    public static final String NO_PERMS = CHAT_PREFIX + Color.c(3) + "You do not have permission for that command.";

    /**
     * Ender Bow No Perms.
     */
    public static final String NO_PERMS_ENDER_BOW = CHAT_PREFIX + Color.c(3) + "You do not have permission to use the Ender Bow.";

    public static void deathLocMessage(Player player, int x, int y, int z, String world) {

        player.sendMessage(CHAT_PREFIX + "You have died at, " +  Color.c(3) + x );
    }
}
