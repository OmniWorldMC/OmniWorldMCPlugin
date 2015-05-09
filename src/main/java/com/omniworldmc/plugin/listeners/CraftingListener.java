package com.omniworldmc.plugin.listeners;

import com.omniworldmc.plugin.OmniWorldMC;
import com.omniworldmc.plugin.api.chat.Returns;
import com.omniworldmc.plugin.util.Recipes;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.Recipe;

public class CraftingListener implements Listener {

    private Recipes recipes = new Recipes();

    public CraftingListener(OmniWorldMC plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onCraft(CraftItemEvent event) {

        Player player = (Player) event.getWhoClicked();
        Recipe eventRecipe = event.getRecipe();
        Recipe enderBow = recipes.enderBow();
        Recipe infEnderBow = recipes.infiniteEnderBow();

        if (eventRecipe == enderBow || eventRecipe == infEnderBow) {

            player.sendMessage(Returns.CHAT_PREFIX + ChatColor.RED + "You do not have permission to craft the enderbow.");
            event.setCancelled(true);

        }
    }
}
