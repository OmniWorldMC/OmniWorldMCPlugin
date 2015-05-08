package com.omniworldmc.plugin.api.chat;

import org.bukkit.ChatColor;

public class Color {

    /**
     * Returns a chat color for chat - Args - int
     * @param code
     * @return ChatColor
     */
    public static ChatColor c(int code) {

        switch (code) {
            case 0:
                return ChatColor.BLACK;
            case 1:
                return ChatColor.DARK_BLUE;
            case 2:
                return ChatColor.DARK_GREEN;
            case 3:
                return ChatColor.DARK_AQUA;
            case 4:
                return ChatColor.DARK_RED;
            case 5:
                return ChatColor.DARK_PURPLE;
            case 6:
                return ChatColor.GOLD;
            case 7:
                return ChatColor.GRAY;
            case 8:
                return ChatColor.DARK_GRAY;
            case 9:
                return ChatColor.BLUE;
        }
        return ChatColor.RESET;
    }

    /**
     * Returns a chat color for chat - Args - String
     * @param code
     * @return ChatColor
     */
    public static ChatColor cs(int code) {
        switch (code) {
            case 1:
                return ChatColor.GREEN;
            case 2:
                return ChatColor.AQUA;
            case 3:
                return ChatColor.RED;
            case 4:
                return ChatColor.LIGHT_PURPLE;
            case 5:
                return ChatColor.YELLOW;
            case 6:
                return ChatColor.WHITE;
        }
        return ChatColor.RESET;
    }

    /**
     * Returns a formatting code for chat.
     * @param code
     * @return ChatColor
     */
    public static ChatColor f(int code) {
        switch (code) {
            case 1:
                return ChatColor.MAGIC;
            case 2:
                return ChatColor.BOLD;
            case 3:
                return ChatColor.STRIKETHROUGH;
            case 4:
                return ChatColor.UNDERLINE;
            case 5:
                return ChatColor.ITALIC;
            case 6:
                return ChatColor.RESET;
        }
        return ChatColor.RESET;
    }
}
