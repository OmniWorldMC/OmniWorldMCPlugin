package com.omniworldmc.plugin.commands;

import com.omniworldmc.plugin.OmniWorldMC;
import com.omniworldmc.plugin.util.Info;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDOM implements CommandExecutor {

    private final OmniWorldMC pl;

    public CMDOM(OmniWorldMC pl) {
        this.pl = pl;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        if (cmd.getName().equalsIgnoreCase("om") && sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("om.cmd.om")) {
                int length = args.length;
                if (length == 0) {
                    player.sendMessage(Info.CHAT_PREFIX + "Please use" + ChatColor.DARK_AQUA + " /om help " + ChatColor.GREEN + "for a full list of commands");
                } else if (length == 1 && args[0].equalsIgnoreCase("help")) {
                    player.sendMessage(ChatColor.DARK_AQUA + "-- " + ChatColor.GREEN + "Commands" + ChatColor.DARK_AQUA + " --");
                    player.sendMessage(ChatColor.DARK_AQUA + "/rage" + ChatColor.GREEN + " - The I AM RAGE! Command.");
                    player.sendMessage(ChatColor.DARK_AQUA + "/healme" + ChatColor.GREEN + " - Heals the player and feeds them.");
                }
            } else {
                player.sendMessage(Info.NO_PERMS);
            }
            return true;
        }
        return false;
    }
}
