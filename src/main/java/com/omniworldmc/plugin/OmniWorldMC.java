package com.omniworldmc.plugin;

import com.omniworldmc.plugin.command.OmCommand;
import com.omniworldmc.plugin.handler.*;
/**import com.omniworldmc.plugin.lib.Reference;**/
import com.omniworldmc.plugin.listener.EnderBowListener;
import com.omniworldmc.plugin.listener.PlayerListener;
/**import org.bukkit.Material;**/
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;**/
import java.util.logging.Level;

public class OmniWorldMC extends JavaPlugin {

    PlayerInteractHandler playerInteractHandler;
    BlockBreakHandler blockBreakHandler;
    CraftItemHandler craftItemHandler;
    EnchantItemHandler enchantItemHandler;
    InventoryClickHandler inventoryClickHandler;
    private PluginManager pm = this.getServer().getPluginManager();

    @Override
    public void onEnable() {

        this.playerInteractHandler = new PlayerInteractHandler();
        this.blockBreakHandler = new BlockBreakHandler();
        this.craftItemHandler = new CraftItemHandler();
        this.enchantItemHandler = new EnchantItemHandler();
        this.inventoryClickHandler = new InventoryClickHandler();

        this.playerInteractHandler.init(this);
        this.blockBreakHandler.init(this);
        this.craftItemHandler.init(this);
        this.enchantItemHandler.init(this);
        this.inventoryClickHandler.init(this);

        this.pm.registerEvents(new EnderBowListener(this), this);
        this.pm.registerEvents(new PlayerListener(this), this);

        this.getCommand("om").setExecutor(new OmCommand(this));

        saveDefaultConfig();

        this.getLogger().log(Level.INFO, "Enabled");
    }

    /**public void processConfig() {
        Iterator localIterator1;
        try {
            Iterator localIterator2;
            for (localIterator1 = ((ArrayList)getConfig().getList("Minable")).iterator(); localIterator1.hasNext(); localIterator2.hasNext()) {
                Object x = localIterator1.next();
                LinkedHashMap<String, ArrayList> l = (LinkedHashMap)x;

                localIterator2 = l.keySet().iterator(); continue;String blockType = (String)localIterator2.next();
                if ((blockType != null) && (!blockType.isEmpty())) {
                    if ((Material.getMaterial(blockType) != null) && (!Reference.MINABLE.containsKey(Material.getMaterial(blockType)))) {
                        Reference.MINABLE.put(Material.getMaterial(blockType), new ArrayList());
                        ArrayList<Material> temp = (ArrayList)Reference.MINABLE.get(Material.getMaterial(blockType));
                        for (Object hammerType : (ArrayList)l.get(blockType)) {
                            if ((hammerType != null) && (!hammerType.isEmpty())) {
                                if (hammerType.equals("any")) {
                                    temp = null;
                                }
                                if ((hammerType == null) || ((Material.getMaterial(String.valueOf(hammerType)) != null) && (
                                        (temp == null) || (!temp.contains(Material.getMaterial(String.valueOf(hammerType))))))) {
                                    if (temp != null) {
                                        temp.add(Material.getMaterial(String.valueOf(hammerType)));
                                    }
                                }
                            }
                        }
                        Reference.MINABLE.put(Material.getMaterial(blockType), temp);
                    }
                }
            }
        }
        catch (NullPointerException e)
        {
            getLogger().info("NPE when trying to read the Minable list from the config file, check if it's set correctly!");
        }
        try
        {
            for (String blockType : getConfig().getStringList("Diggable")) {
                if ((blockType != null) && (!blockType.isEmpty())) {
                    if ((Material.getMaterial(blockType) != null) && (!Reference.DIGGABLE.contains(Material.getMaterial(blockType)))) {
                        Reference.DIGGABLE.add(Material.getMaterial(blockType));
                    }
                }
            }
        }
        catch (NullPointerException e)
        {
            getLogger().info("NPE when trying to read the Digable list from the config file, check if it's set correctly!");
        }
    }**/

    @Override
    public void onDisable() {

        this.getLogger().log(Level.INFO, "Disabled");
    }

    public PlayerInteractHandler getPlayerInteractHandler() {
        return playerInteractHandler;
    }

    public BlockBreakHandler getBlockBreakHandler() {
        return blockBreakHandler;
    }

    public CraftItemHandler getCraftItemHandler() {
        return craftItemHandler;
    }

    public EnchantItemHandler getEnchantItemHandler() {
        return enchantItemHandler;
    }

    public InventoryClickHandler getInventoryClickHandler() {
        return inventoryClickHandler;
    }
}
