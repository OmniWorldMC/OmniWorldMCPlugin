package com.omniworldmc.plugin.handler;

import com.omniworldmc.plugin.OmniWorldMC;
import com.omniworldmc.plugin.listener.BlockBreakListener;

public class BlockBreakHandler {
    public BlockBreakListener listener;

    public void init(OmniWorldMC plugin) {
        this.listener = new BlockBreakListener(plugin);
    }

    public BlockBreakListener getListener() {
        return this.listener;
    }
}
