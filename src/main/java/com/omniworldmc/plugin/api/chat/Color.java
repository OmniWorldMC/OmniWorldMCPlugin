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
    public static ChatColor c(String code) {
        switch (code) {
            case "a":
                return ChatColor.GREEN;
            case "b":
                return ChatColor.AQUA;
            case "c":
                return ChatColor.RED;
            case "d":
                return ChatColor.LIGHT_PURPLE;
            case "e":
                return ChatColor.YELLOW;
            case "f":
                return ChatColor.WHITE;
        }
        return ChatColor.RESET;
    }

    /**
     * Returns a formatting code for chat.
     * @param code
     * @return ChatColor
     */
    public static ChatColor f(String code) {
        switch (code) {
            case "k":
                return ChatColor.MAGIC;
            case "l":
                return ChatColor.BOLD;
            case "m":
                return ChatColor.STRIKETHROUGH;
            case "n":
                return ChatColor.UNDERLINE;
            case "o":
                return ChatColor.ITALIC;
            case "r":
                return ChatColor.RESET;
        }
        return ChatColor.RESET;
    }
}
