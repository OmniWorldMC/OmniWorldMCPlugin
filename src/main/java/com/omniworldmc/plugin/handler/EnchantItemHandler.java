package com.omniworldmc.plugin.handler;

import com.omniworldmc.plugin.OmniWorldMC;
import com.omniworldmc.plugin.listener.EnchantItemListener;

public class EnchantItemHandler {

    public EnchantItemListener listener;

    public void init(OmniWorldMC plugin) {
        this.listener = new EnchantItemListener(plugin);
    }

    public EnchantItemListener getListener() {
        return this.listener;
    }
}
