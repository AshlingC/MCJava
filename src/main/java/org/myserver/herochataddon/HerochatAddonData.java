package org.myserver.herochataddon;

import org.bukkit.ChatColor;

import java.util.HashMap;
import java.util.UUID;

public class HerochatAddonData {

    private static final HashMap<UUID, ChatColor> playerColors = new HashMap<>();

    public static void setPlayerEmoteColor(UUID playerUuid, ChatColor color) {
        playerColors.put(playerUuid, color);
    }

    public static ChatColor getPlayerEmoteColor(UUID playerUuid) {
        return playerColors.getOrDefault(playerUuid, ChatColor.WHITE); // Default to white if not set
    }
}
