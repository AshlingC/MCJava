package org.myserver.herochataddon;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    private final HerochatAddon plugin;

    public ChatListener(HerochatAddon plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        ChatColor emoteColor = HerochatAddonData.getPlayerEmoteColor(event.getPlayer().getUniqueId());

        if (message.startsWith("*")) {
            event.setMessage(emoteColor + event.getPlayer().getDisplayName() + " " + message.substring(1));
        } else if (message.startsWith("!")) {
            event.setMessage(emoteColor + "[" + message.substring(1) + "]");
        } else if (message.contains("\"")) {
            String before = emoteColor + message.substring(0, message.indexOf("\""));
            String quoted = ChatColor.WHITE + message.substring(message.indexOf("\""), message.lastIndexOf("\"") + 1);
            String after = emoteColor + message.substring(message.lastIndexOf("\"") + 1);
            event.setMessage(before + quoted + after);
        }
    }
}
