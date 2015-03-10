package com.omniworldmc.plugin.commands;

import com.omniworldmc.plugin.OmniWorldMC;
import com.omniworldmc.plugin.util.Info;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

public class CMDHealME implements CommandExecutor {

    private final OmniWorldMC pl;

    public CMDHealME(OmniWorldMC pl) {
        this.pl = pl;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        if (cmd.getName().equalsIgnoreCase("healme") && sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("om.cmd.healme")) {
                player.setHealth(20.0);
                player.sendMessage(Info.CHAT_PREFIX + "You have been healed!");
            } else {
                player.sendMessage(Info.NO_PERMS);
            }
        }
        return false;
    }
}
