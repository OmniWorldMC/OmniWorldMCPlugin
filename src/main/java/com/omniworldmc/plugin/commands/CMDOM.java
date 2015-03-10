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
                player.sendMessage(Info.CHAT_PREFIX + "Please use" + ChatColor.DARK_AQUA + " /om help " + ChatColor.GREEN + "for a full list of commands");
                if (args.length == 1 && args[0] == "help") {
                    player.sendMessage(Info.CHAT_PREFIX + "/rage and /healme");
                }
            } else {
                player.sendMessage(Info.NO_PERMS);
            }
            return true;
        }
        return false;
    }
}
