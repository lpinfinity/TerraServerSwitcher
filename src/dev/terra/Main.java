package dev.terra;

import dev.terra.commands.ServerSwitcher;
import dev.terra.commands.SetTeleporters;
import dev.terra.events.PlayerJoin;
import dev.terra.events.PressurePlateEvent;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public FileConfiguration config = getConfig();

    @Override
    public void onEnable() {

        config.addDefault("SurvivalTeleporter", "null");
        config.options().copyDefaults(true);
        saveConfig();

        this.getCommand("hub").setExecutor(new ServerSwitcher());
        this.getCommand("survival").setExecutor(new ServerSwitcher());
        this.getCommand("setsurvivalteleporter").setExecutor(new SetTeleporters(this));
        this.getCommand("setspleefteleporter").setExecutor(new SetTeleporters(this));

        getServer().getPluginManager().registerEvents(new PressurePlateEvent(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);

        System.out.println("TerraServerSwitcher has started");

    }

    @Override
    public void onDisable() {
        System.out.println("TerraServerSwitcher has stopped");
    }

}
