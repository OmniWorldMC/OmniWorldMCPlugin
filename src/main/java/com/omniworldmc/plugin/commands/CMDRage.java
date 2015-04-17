package com.omniworldmc.plugin.commands;

import com.omniworldmc.plugin.OmniWorldMC;
import com.omniworldmc.plugin.api.chat.Color;
import com.omniworldmc.plugin.api.chat.Returns;
import com.omniworldmc.plugin.api.gui.Title;
import com.omniworldmc.plugin.util.Perms;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdRage implements CommandExecutor {
    private final OmniWorldMC pl;

    public CmdRage(OmniWorldMC pl) {
        this.pl = pl;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("rage") && sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(Perms.RAGE)) {
                player.performCommand("shock");
                player.chat("I AM RAGE!");
                Title title = new Title("RAGE!");
                title.setTitleColor(Color.c("e"));
                title.broadcast();
                player.sendRawMessage(ChatColor.YELLOW + player.getName() + " has used the powers of RAGE!");
            } else {
                player.sendMessage(Returns.NO_PERMS);
            }
            return true;
        }
        return false;
    }
}
