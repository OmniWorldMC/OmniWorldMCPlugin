package com.omniworldmc.plugin.listeners;

import com.omniworldmc.plugin.OmniWorldMC;
import com.omniworldmc.plugin.api.chat.Returns;
import com.omniworldmc.plugin.util.Perms;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;

public class EnderBowListener implements Listener {

    private final OmniWorldMC plugin;

    public EnderBowListener(OmniWorldMC plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onShootBow(EntityShootBowEvent event) {
        if ((event.getEntity() instanceof Player)) {
            Player player = (Player)event.getEntity();
            if ((event.getBow().getEnchantmentLevel(Enchantment.ARROW_INFINITE) == 2) || (event.getBow().getEnchantmentLevel(Enchantment.ARROW_INFINITE) == 3)) {
                if (player.hasPermission(Perms.USE_ENDERBOW)) {
                    if (player.getInventory().contains(Material.ENDER_PEARL)) {
                        if (event.getBow().getEnchantmentLevel(Enchantment.ARROW_INFINITE) == 2) {
                            event.setCancelled(true);
                            player.getInventory().removeItem(new ItemStack[] { new ItemStack(Material.ENDER_PEARL, 1) });
                            ((EnderPearl)player.launchProjectile(EnderPearl.class)).setVelocity(event.getProjectile().getVelocity().multiply(1.1D));
                            player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
                        } else if (event.getBow().getEnchantmentLevel(Enchantment.ARROW_INFINITE) == 3) {
                            event.setCancelled(true);
                            ((EnderPearl)player.launchProjectile(EnderPearl.class)).setVelocity(event.getProjectile().getVelocity().multiply(1.1D));
                            player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
                            event.getBow().setDurability((short) 384);
                        }
                    }
                    else {
                        event.setCancelled(true);
                    }
                } else {
                    player.sendMessage(Returns.NO_PERMS_ENDER_BOW);
                }
            }
            else {}
        }
    }
}
