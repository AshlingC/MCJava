package org.myserver.herochataddon;

import org.bukkit.plugin.java.JavaPlugin;

public class HerochatAddon extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("setemotecolor").setExecutor(new SetEmoteColorCommand());
        getServer().getPluginManager().registerEvents(new ChatListener(this), this);
    }
}
