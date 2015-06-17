package com.omniworldmc.plugin.lib;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Reference
{
    public static HashMap<Material, ArrayList<Material>> MINABLE = new HashMap();
    public static ArrayList<Material> DIGGABLE = new ArrayList();
    public static ArrayList<Material> MINABLE_SILKTOUCH = new ArrayList(Arrays.asList(new Material[]{
            Material.STONE,
            Material.COAL_ORE,
            Material.REDSTONE_ORE,
            Material.GLOWING_REDSTONE_ORE,
            Material.LAPIS_ORE,
            Material.DIAMOND_ORE,
            Material.EMERALD_ORE,
            Material.ICE,
            Material.QUARTZ_ORE,
            Material.GLOWSTONE}));
    public static ArrayList<Material> DIGGABLE_SILKTOUCH = new ArrayList(Arrays.asList(new Material[] {
            Material.GRASS,
            Material.CLAY,
            Material.SNOW_BLOCK,
            Material.MYCEL,
            Material.GLOWSTONE }));
    public static HashMap<Material, Material> MINABLE_FORTUNE = new HashMap();
    public static HashMap<Material, Material> DIGGABLE_FORTUNE;

    static
    {
        MINABLE_FORTUNE.put(Material.COAL_ORE, Material.COAL);
        MINABLE_FORTUNE.put(Material.REDSTONE_ORE, Material.REDSTONE);
        MINABLE_FORTUNE.put(Material.GLOWING_REDSTONE_ORE, Material.REDSTONE);
        MINABLE_FORTUNE.put(Material.LAPIS_ORE, Material.INK_SACK);
        MINABLE_FORTUNE.put(Material.DIAMOND_ORE, Material.DIAMOND);
        MINABLE_FORTUNE.put(Material.EMERALD_ORE, Material.EMERALD);
        MINABLE_FORTUNE.put(Material.QUARTZ_ORE, Material.QUARTZ);
        MINABLE_FORTUNE.put(Material.GLOWSTONE, Material.GLOWSTONE_DUST);




        DIGGABLE_FORTUNE = new HashMap();

        DIGGABLE_FORTUNE.put(Material.GRAVEL, Material.FLINT);
        DIGGABLE_FORTUNE.put(Material.GLOWSTONE, Material.GLOWSTONE_DUST);
    }

    public static ArrayList<Material> PICKAXES = new ArrayList(Arrays.asList(new Material[] {
            Material.DIAMOND_PICKAXE }));
    public static ArrayList<Material> SPADES = new ArrayList(Arrays.asList(new Material[] {
            Material.DIAMOND_SPADE }));
}

