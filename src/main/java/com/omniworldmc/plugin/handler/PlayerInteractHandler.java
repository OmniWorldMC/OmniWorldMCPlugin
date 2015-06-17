package com.omniworldmc.plugin.handler;

import com.omniworldmc.plugin.OmniWorldMC;
import com.omniworldmc.plugin.listener.PlayerInteractListener;

public class PlayerInteractHandler {

    public PlayerInteractListener listener;

    public void Init(OmniWorldMC plugin) {
        this.listener = new PlayerInteractListener(plugin);
    }

    public PlayerInteractListener getListener() {
        return this.listener;
    }
}
