package com.omniworldmc.plugin.commands;

import com.omniworldmc.plugin.OmniWorldMC;
import com.omniworldmc.plugin.util.Info;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDKillLegeis implements CommandExecutor {

    private final OmniWorldMC pl;

    public CMDKillLegeis(OmniWorldMC pl) {
        this.pl = pl;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String strings, String[] args) {
        if (cmd.getName().equalsIgnoreCase("die") && sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("om.cmd.die")) {
                for (Player playerToKill : Bukkit.getServer().getOnlinePlayers()) {
                    if (playerToKill.getName().equals("Legeis")) {
                        playerToKill.setHealth(0.0);
                        player.sendMessage(Info.CHAT_PREFIX);
                        player.sendMessage(Info.CHAT_PREFIX + "Legeis has been murdered.");
                    } else {
                        player.sendMessage(Info.CHAT_PREFIX + "Legeis is not online.");
                    }
                    break;
                }
            } else {
                player.sendMessage(Info.NO_PERMS);
            }
            return true;
        }
        return false;
    }
}
