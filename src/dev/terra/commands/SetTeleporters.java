package dev.terra.commands;

import dev.terra.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetTeleporters implements CommandExecutor {

    private final Main main;

    public SetTeleporters(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if(sender instanceof Player) {

            Player player = (Player) sender;

            if(command.getName().equalsIgnoreCase("setsurvivalteleporter")) {
                main.config.set("SurvivalTeleporter", (player.getLocation().getBlock().getX() + " " + player.getLocation().getBlock().getY() + " " + player.getLocation().getBlock().getZ()));
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tell " + player.getName() + " Survival Teleporter set to " + (player.getLocation().getBlock().getX() + " " + player.getLocation().getBlock().getY() + " " + player.getLocation().getBlock().getZ()));
                main.saveConfig();
            }

            if(command.getName().equalsIgnoreCase("setspleefteleporter")) {
                main.config.set("SpleefTeleporter", (player.getLocation().getBlock().getX() + " " + player.getLocation().getBlock().getY() + " " + player.getLocation().getBlock().getZ()));
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tell " + player.getName() + " Spleef Teleporter set to " + (player.getLocation().getBlock().getX() + " " + player.getLocation().getBlock().getY() + " " + player.getLocation().getBlock().getZ()));
                main.saveConfig();
            }

        }

        return false;
    }

}
