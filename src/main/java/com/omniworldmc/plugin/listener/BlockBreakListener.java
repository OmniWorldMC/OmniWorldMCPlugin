package com.omniworldmc.plugin.listener;

import com.omniworldmc.plugin.OmniWorldMC;
import com.omniworldmc.plugin.lib.PowerUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Map;
import java.util.UUID;

public class BlockBreakListener implements Listener {

    public OmniWorldMC plugin;
    public boolean useDurabilityPerBlock;

    public BlockBreakListener(OmniWorldMC plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);

        this.useDurabilityPerBlock = plugin.getConfig().getBoolean("useDurabilityPerBlock");
    }

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void checkToolAndBreakBlocks(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ItemStack handItem = player.getItemInHand();
        Material handItemType = handItem.getType();

        if ((player != null) && ((player instanceof Player))) {
            if (player.isSneaking()) {
                return;
            }
            if (!PowerUtils.checkUsePermission(player, handItemType)) {
                return;
            }
            if (!PowerUtils.isPowerTool(handItem)) {
             return;
            }

            Block block = event.getBlock();
            UUID playerUUID = player.getUniqueId();

            PlayerInteractListener pil = this.plugin.getPlayerInteractHandler().getListener();
            BlockFace blockFace = pil.getBlockFaceByUUID(playerUUID);

            Map<Enchantment, Integer> enchants = handItem.getEnchantments();
            Enchantment enchant = null;
            int enchantLevel = 0;
            if (enchants.get(Enchantment.SILK_TOUCH) != null) {
                enchant = Enchantment.SILK_TOUCH;
                enchantLevel = ((Integer) enchants.get(Enchantment.SILK_TOUCH)).intValue();
            } else if (enchants.get(Enchantment.LOOT_BONUS_BLOCKS) != null) {
                enchant = Enchantment.LOOT_BONUS_BLOCKS;
                enchantLevel = ((Integer) enchants.get(Enchantment.LOOT_BONUS_BLOCKS)).intValue();
            }

            short curDur = handItem.getDurability();
            short maxDur = handItem.getType().getMaxDurability();

            for (Block e : PowerUtils.getSurroundingBlocks(blockFace, block)) {
                Material blockMat = e.getType();
                Location blockLoc = e.getLocation();

                boolean useHammer = false;
                boolean useExcavator = false;

                if ((((useHammer = PowerUtils.validateHammer(handItemType, blockMat))) || (!(useExcavator = PowerUtils.validateExcavator(handItemType, blockMat)))) || ((useHammer) || (useExcavator))) {
                    if (PowerUtils.canBreak(plugin, player, e)) {
                        if ((blockMat == Material.SNOW) && (useExcavator)) {
                            ItemStack snow = new ItemStack(Material.SNOW_BALL, 1, e.getData());
                            e.getWorld().dropItemNaturally(blockLoc, snow);
                        }
                        if ((enchant == null) || (
                                ((PowerUtils.canSilkTouchMine(blockMat)) && (PowerUtils.canFortuneMine(blockMat))) || ((useHammer) || (
                                        ((!PowerUtils.canFortuneDig(blockMat)) || (!PowerUtils.canFortuneDig(blockMat))) && (useExcavator)))))
                        {
                    }
                }
            }
        }
    }
}
