package com.omniworldmc.plugin.commands;

import com.omniworldmc.plugin.OmniWorldMC;
import com.omniworldmc.plugin.util.Info;
import com.omniworldmc.plugin.util.Perms;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class CMDOM implements CommandExecutor {

    private final OmniWorldMC pl;
    OmniWorldMC configGetter;

    public CMDOM(OmniWorldMC pl) {
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
                    Info.noPerms(player, "cmd");
                }
            } else if (length == 1 && args[0].equalsIgnoreCase("reload")) {
                if (player.hasPermission(Perms.OM_RELOAD)) {
                    configGetter.reloadConfig();
                    player.sendMessage(Info.CHAT_PREFIX + "Config Reloaded.");
                } else {
                    Info.noPerms(player, "cmd");
                }
            } else {
                if (player.hasPermission(Perms.OM)) {
                    player.sendMessage(Info.CHAT_PREFIX + "Please use" + ChatColor.DARK_AQUA  + " /om help " + ChatColor.GREEN + "for a list of commands.");
                } else {
                    Info.noPerms(player, "cmd");
                }
            }
            return true;
        }
        return false;
    }
}
