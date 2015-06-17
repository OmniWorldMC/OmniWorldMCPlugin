package com.omniworldmc.plugin.lib;

import com.omniworldmc.plugin.OmniWorldMC;
import com.omniworldmc.plugin.crafting.CraftItemExcavator;
import com.omniworldmc.plugin.crafting.CraftItemHammer;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PowerUtils {
    public static double CHANCE_FORTUNE_I = 0.33D;
    public static double CHANCE_FORTUNE_II = 0.25D;
    public static double CHANCE_FORTUNE_III = 0.2D;

    public static boolean isPowerTool(ItemStack item) {
        if ((item == null) || (!item.hasItemMeta())) {
            return false;
        }
        List<String> lore = item.getItemMeta().getLore();
        if (lore == null) {
            return false;
        }
        return (Reference.PICKAXES.contains(item.getType())) || ((Reference.SPADES.contains(item.getType())) && (
                (lore.contains(CraftItemHammer.loreString)) || (lore.contains(CraftItemExcavator.loreString))));
    }

    public static int getAmountPerFortune(int level, int amount) {
        Random rand = new Random();
        if ((level == 1) && (rand.nextDouble() <= CHANCE_FORTUNE_I)) {
            return amount * 2;
        }
        if (level == 2) {
            if (rand.nextDouble() <= CHANCE_FORTUNE_II) {
                return amount * 3;
            }
            if (rand.nextDouble() <= CHANCE_FORTUNE_II) {
                return amount * 2;
            }
        } else if (level == 3) {
            if (rand.nextDouble() <= CHANCE_FORTUNE_III) {
                return amount * 4;
            }
            if (rand.nextDouble() <= CHANCE_FORTUNE_III) {
                return amount * 3;
            }
            if (rand.nextDouble() <= CHANCE_FORTUNE_III) {
                return amount * 2;
            }
        }
        return amount;
    }

    public static double getFlintDropChance(int level) {
        double chance = 0.1D;
        if (level == 1) {
            chance = 0.14D;
        } else if (level == 2) {
            chance = 0.25D;
        } else if (level == 3) {
            chance = 1.0D;
        }
        return chance;
    }

    public static boolean canSilkTouchMine(Material blockType) {
        return Reference.MINABLE_SILKTOUCH.contains(blockType);
    }

    public static boolean canSilkTouchDig(Material blockType) {
        return Reference.DIGGABLE_SILKTOUCH.contains(blockType);
    }

    public static boolean canFortuneMine(Material blockType) {
        return Reference.MINABLE_FORTUNE.get(blockType) != null;
    }

    public static boolean canFortuneDig(Material blockType) {
        return Reference.DIGGABLE_FORTUNE.get(blockType) != null;
    }

    public static boolean isMineable(Material blockType) {
        return Reference.MINABLE.containsKey(blockType);
    }

    public static boolean isDigable(Material blockType) {
        return Reference.DIGGABLE.contains(blockType);
    }

    public static ItemStack processEnchantsAndReturnItemStack(Enchantment enchant, int enchantLevel, Block block) {
        Material blockType = block.getType();
        ItemStack drop = null;
        if (enchant == Enchantment.SILK_TOUCH) {
            drop = new ItemStack(blockType, 1);
        } else if (enchant == Enchantment.LOOT_BONUS_BLOCKS) {
            int amount = 0;
            Random rand = new Random();
            if (Reference.MINABLE_FORTUNE.get(blockType) != null) {
                switch (blockType) {
                    case DIAMOND_HELMET:
                        amount = Math.min(rand.nextInt(5) + 2 + enchantLevel, 4);

                        break;
                    case CROPS:
                    case DARK_OAK_DOOR:
                        amount = Math.min(rand.nextInt(2) + 4 + enchantLevel, 8);

                        break;
                    case BEDROCK:
                    case CLAY_BRICK:
                    case FISHING_ROD:
                    case GOLD_ORE:
                        amount = getAmountPerFortune(enchantLevel, 1);
                        break;
                    case BIRCH_FENCE_GATE:
                        amount = Math.min(getAmountPerFortune(enchantLevel, rand.nextInt(5) + 4), 32);
                        break;
                }
                if (amount > 0) {
                    if (blockType == Material.LAPIS_ORE) {
                        drop = new ItemStack((Material)Reference.MINABLE_FORTUNE.get(blockType), amount, (short)4);
                    } else {
                        drop = new ItemStack((Material)Reference.MINABLE_FORTUNE.get(blockType), amount);
                    }
                }
            } else if (Reference.DIGGABLE_FORTUNE.get(blockType) != null) {
                if (blockType == Material.GLOWSTONE) {
                    amount = Math.min(rand.nextInt(5) + 2 + enchantLevel, 4);

                    drop = new ItemStack((Material)Reference.DIGGABLE_FORTUNE.get(blockType), amount);
                } else if (blockType == Material.GRAVEL) {
                    if (rand.nextDouble() <= getFlintDropChance(enchantLevel)) {
                        drop = new ItemStack((Material)Reference.DIGGABLE_FORTUNE.get(blockType), 1);
                    } else {
                        drop = new ItemStack(blockType, 1);
                    }
                }
            }
        }
        return drop;
    }

    public static ArrayList<Block> getSurroundingBlocks(BlockFace blockFace, Block targetBlock) {
        ArrayList<Block> blocks = new ArrayList();
        World world = targetBlock.getWorld();


        int x = targetBlock.getX();
        int y = targetBlock.getY();
        int z = targetBlock.getZ();
        switch (blockFace) {
            case NORTH:
            case NORTH_EAST:
                blocks.add(world.getBlockAt(x + 1, y, z));
                blocks.add(world.getBlockAt(x - 1, y, z));
                blocks.add(world.getBlockAt(x, y, z + 1));
                blocks.add(world.getBlockAt(x, y, z - 1));
                blocks.add(world.getBlockAt(x + 1, y, z + 1));
                blocks.add(world.getBlockAt(x - 1, y, z - 1));
                blocks.add(world.getBlockAt(x + 1, y, z - 1));
                blocks.add(world.getBlockAt(x - 1, y, z + 1));
                break;
            case EAST:
            case EAST_SOUTH_EAST:
                blocks.add(world.getBlockAt(x, y, z + 1));
                blocks.add(world.getBlockAt(x, y, z - 1));
                blocks.add(world.getBlockAt(x, y + 1, z));
                blocks.add(world.getBlockAt(x, y - 1, z));
                blocks.add(world.getBlockAt(x, y + 1, z + 1));
                blocks.add(world.getBlockAt(x, y - 1, z - 1));
                blocks.add(world.getBlockAt(x, y - 1, z + 1));
                blocks.add(world.getBlockAt(x, y + 1, z - 1));
                break;
            case DOWN:
            case EAST_NORTH_EAST:
                blocks.add(world.getBlockAt(x + 1, y, z));
                blocks.add(world.getBlockAt(x - 1, y, z));
                blocks.add(world.getBlockAt(x, y + 1, z));
                blocks.add(world.getBlockAt(x, y - 1, z));
                blocks.add(world.getBlockAt(x + 1, y + 1, z));
                blocks.add(world.getBlockAt(x - 1, y - 1, z));
                blocks.add(world.getBlockAt(x + 1, y - 1, z));
                blocks.add(world.getBlockAt(x - 1, y + 1, z));
                break;
        }
        blocks.removeAll(Collections.singleton(null));
        return blocks;
    }

    public static boolean checkCraftPermission(Player player, Material itemType) {
        boolean canCraft = false;
        switch (itemType) {
            case MILK_BUCKET:
                if (player.hasPermission("tconstruct.craft.hammer.diamond")) {
                    canCraft = true;
                }
                break;
            case MELON_STEM:
                if (player.hasPermission("tconstruct.craft.excavator.diamond")) {
                    canCraft = true;
                }
                break;
        }
        return canCraft;
    }

    public static boolean checkUsePermission(Player player, Material itemType) {
        boolean canUse = false;
        switch (player.getItemInHand().getType()) {
            case MILK_BUCKET:
                if (player.hasPermission("tconstruct.use.hammer.diamond")) {
                    canUse = true;
                }
                break;
            case MELON_STEM:
                if (player.hasPermission("tconstruct.use.excavator.diamond")) {
                    canUse = true;
                }
                break;
        }
        return canUse;
    }

    public static boolean checkEnchantPermission(Player player, Material itemType) {
        boolean canEnchant = false;
        switch (itemType) {
            case MILK_BUCKET:
                if (player.hasPermission("tconstruct.enchant.hammer.diamond")) {
                    canEnchant = true;
                }
                break;
            case MELON_STEM:
                if (player.hasPermission("tconstruct.enchant.excavator.diamond")) {
                    canEnchant = true;
                }
                break;
        }
        return canEnchant;
    }

    public static boolean canBreak(OmniWorldMC plugin, Player player, Block block) {
        return true;
    }

    public static boolean validateHammer(Material hammerType, Material blockType) {
        return (isMineable(blockType)) && (Reference.PICKAXES.contains(hammerType)) && (
                (Reference.MINABLE.get(blockType) == null) || (((ArrayList)Reference.MINABLE.get(blockType)).contains(hammerType)));
    }

    public static boolean validateExcavator(Material excavatorType, Material blockType) {
        return (isDigable(blockType)) && (Reference.SPADES.contains(excavatorType));
    }
}
