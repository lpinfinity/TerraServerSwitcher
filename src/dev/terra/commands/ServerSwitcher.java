package dev.terra.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ServerSwitcher implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if(sender instanceof Player) {

            Player player = (Player) sender;

            if(command.getName().equalsIgnoreCase("hub")) {
                Bukkit.dispatchCommand(player, "server hub");
            }else if(command.getName().equalsIgnoreCase("survival")) {
                Bukkit.dispatchCommand(player, "server survival");
            }else{
                return false;
            }

        }

        return false;
    }

}
