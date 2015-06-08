package com.omniworldmc.plugin.command;

import com.omniworldmc.plugin.OmniWorldMC;
import com.omniworldmc.plugin.lib.ChatLib;
import com.omniworldmc.plugin.lib.PermLib;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class OmCommand implements CommandExecutor {

    private final OmniWorldMC plugin;

    public OmCommand(OmniWorldMC plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender source, Command cmd, String alias, String[] args) {

        int length = args.length;

        if (cmd.getName().equalsIgnoreCase("om")) {
            if (source.hasPermission(PermLib.CMD_OM)) {
                source.sendMessage(ChatLib.CHAT_PREFIX + "This command does nothing.");
            } else {
                source.sendMessage(ChatLib.NO_PERMS);
            }
        }
        return false;
    }
}
