package com.omniworldmc.plugin.commands;

import com.omniworldmc.plugin.OmniWorldMC;
import com.omniworldmc.plugin.api.chat.Color;
import com.omniworldmc.plugin.api.chat.Returns;
import com.omniworldmc.plugin.util.Perms;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdOm implements CommandExecutor {

    private final OmniWorldMC pl;
    OmniWorldMC configGetter;

    public CmdOm(OmniWorldMC pl) {
        this.pl = pl;
        configGetter = pl;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        if (cmd.getName().equalsIgnoreCase("om") && sender instanceof Player) {
            Player player = (Player) sender;
            int length = args.length;
            if (length == 1 && args[0].equalsIgnoreCase("help")) {
                if (player.hasPermission(Perms.OM_HELP)) {
                    player.sendMessage(ChatColor.GREEN + "-- " + ChatColor.DARK_AQUA + "Commands" + ChatColor.GREEN + " --");
                    player.sendMessage(ChatColor.DARK_AQUA + "/om help" + ChatColor.GREEN + " - The command you are looking at now >:)");
                    if (player.hasPermission(Perms.OM_RELOAD)) {
                        player.sendMessage(ChatColor.DARK_AQUA + "/om reload" + ChatColor.GREEN + " - Reloads The OmniWorldMC Plugin.");
                    } if (player.hasPermission(Perms.RAGE)) {
                        player.sendMessage(ChatColor.DARK_AQUA + "/rage" + ChatColor.GREEN + " - Summons the power of RAGE!");
                    }
                } else {
                    player.sendMessage(Returns.NO_PERMS);
                }
            } else if (length == 1 && args[0].equalsIgnoreCase("reload")) {
                if (player.hasPermission(Perms.OM_RELOAD)) {
                    try {
                        configGetter.reloadConfig();
                        player.sendMessage(Returns.CHAT_PREFIX + "Config Reloaded.");
                    } catch (Exception e) {
                        e.printStackTrace();
                        player.sendMessage(Returns.CHAT_PREFIX + Color.c("c") + "A fatal error has occurred while attempting to reload the config.");
                        player.sendMessage(Returns.CHAT_PREFIX + Color.c("c") + "Please report this to Chaka.");
                    }
                } else {
                    player.sendMessage(Returns.NO_PERMS);
                }
            } else {
                if (player.hasPermission(Perms.OM)) {
                    player.sendMessage(Returns.CHAT_PREFIX + "Please use" + ChatColor.DARK_AQUA  + " /om help " + ChatColor.GREEN + "for a list of commands.");
                } else {
                    player.sendMessage(Returns.NO_PERMS);
                }
            }
            return true;
        }
        return false;
    }
}
