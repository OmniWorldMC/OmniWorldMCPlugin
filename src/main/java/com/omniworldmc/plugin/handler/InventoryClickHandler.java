package com.omniworldmc.plugin.handler;

import com.omniworldmc.plugin.OmniWorldMC;
import com.omniworldmc.plugin.listener.InventoryClickListener;

public class InventoryClickHandler {

    public InventoryClickListener listener;

    public void init(OmniWorldMC plugin) {

        this.listener = new InventoryClickListener(plugin);
    }

    public InventoryClickListener getListener() {
        return this.listener;
    }
}
