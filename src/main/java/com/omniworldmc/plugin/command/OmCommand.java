package com.omniworldmc.plugin.command;

import com.omniworldmc.plugin.OmniWorldMC;
import com.omniworldmc.plugin.crafting.CraftItemExcavator;
import com.omniworldmc.plugin.crafting.CraftItemHammer;
import com.omniworldmc.plugin.handler.PlayerInteractHandler;
import com.omniworldmc.plugin.lib.ChatLib;
import com.omniworldmc.plugin.lib.PermLib;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OmCommand implements CommandExecutor {

    private final OmniWorldMC plugin;
    private CraftItemHammer hammer;
    private CraftItemExcavator excavator;

    public OmCommand(OmniWorldMC plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender source, Command cmd, String alias, String[] args) {

        int length = args.length;

        if (cmd.getName().equalsIgnoreCase("om")) {
            if (source.hasPermission(PermLib.CMD_OM)) {
                if (length <= 1) {

                } else if (length == 2 || length == 3 || length == 4) {
                    if (args[0].equalsIgnoreCase("give")) {
                        Player player = (Player) source;
                        if (args[2].equalsIgnoreCase("hammer")) {
                            player.getInventory().addItem(hammer.DiamondHammer);
                        } else if (args[2].equalsIgnoreCase("excavator")) {
                            player.getInventory().addItem(excavator.DiamondExcavator);
                        }
                    }
                }
            } else {
                source.sendMessage(ChatLib.NO_PERMS);
            }
            return true;
        }
        return false;
    }
}
