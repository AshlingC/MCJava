package org.myserver.herochataddon;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetEmoteColorCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage(ChatColor.RED + "Usage: /setemotecolor <color>");
            return true;
        }

        ChatColor color;
        try {
            color = ChatColor.valueOf(args[0].toUpperCase());
        } catch (IllegalArgumentException e) {
            sender.sendMessage(ChatColor.RED + "Invalid color.");
            return true;
        }

        Player player = (Player) sender;
        HerochatAddonData.setPlayerEmoteColor(player.getUniqueId(), color);
        player.sendMessage(ChatColor.GREEN + "Your emote color has been set to " + color + color.name());
        return true;
    }
}
