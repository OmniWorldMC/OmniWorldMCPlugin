package com.omniworldmc.plugin.commands;

import com.omniworldmc.plugin.OmniWorldMC;
import com.omniworldmc.plugin.api.chat.Returns;
import com.omniworldmc.plugin.util.Info;
import com.omniworldmc.plugin.util.Perms;
import com.omniworldmc.plugin.util.Recipes;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDRage implements CommandExecutor {
    private final OmniWorldMC pl;

    public CMDRage(OmniWorldMC pl) {
        this.pl = pl;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("rage") && sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(Perms.RAGE)) {
                player.performCommand("shock");
                player.chat("I AM RAGE!");
                player.sendRawMessage(ChatColor.YELLOW + player.getName() + " has used the powers of RAGE!");
            } else {
                Returns.noPermsReturn("cmd", "rage", player);
            }
            return true;
        }
        return false;
    }
}
