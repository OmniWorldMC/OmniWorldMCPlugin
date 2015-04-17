package com.omniworldmc.plugin.api.chat;

public class Returns {

    /**
     * Returns the official chat prefix with a green output.
     */
    public static final String CHAT_PREFIX = Color.c("f") + "[" + Color.c("b") + "OmniWorld" + Color.c(6) + "MC" + Color.c("f") + "] " + Color.c("a");

    /**
     * No permission message.
     */
    public static final String NO_PERMS = CHAT_PREFIX + Color.c("c") + "You do not have permission for that command.";

    /**
     * Ender Bow No Perms.
     */
    public static final String NO_PERMS_ENDER_BOW = CHAT_PREFIX + Color.c("c") + "You do not have permission to use the Ender Bow.";
}
