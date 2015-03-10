package com.omniworldmc.plugin.commands;

import com.omniworldmc.plugin.OmniWorldMC;
import com.omniworldmc.plugin.util.Info;
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
            if (player.hasPermission("om.cmd.rage")) {
                player.performCommand("shock");
                player.chat("I AM RAGE!");
            } else {
                player.sendMessage(Info.NO_PERMS);
            }
            return true;
        }
        return false;
    }
}
