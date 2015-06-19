package com.omniworldmc.plugin.handler;

import com.omniworldmc.plugin.OmniWorldMC;
import com.omniworldmc.plugin.crafting.CraftItemExcavator;
import com.omniworldmc.plugin.crafting.CraftItemHammer;
import com.omniworldmc.plugin.listener.CraftItemListener;

public class CraftItemHandler {

    public CraftItemHammer craftItemHammer;
    public CraftItemExcavator craftItemExcavator;
    public CraftItemListener listener;

    public void init(OmniWorldMC plugin) {
        this.craftItemHammer = new CraftItemHammer(plugin);
        this.craftItemExcavator = new CraftItemExcavator(plugin);
        this.listener = new CraftItemListener(plugin);
    }
}
