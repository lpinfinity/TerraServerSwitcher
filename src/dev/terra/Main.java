package dev.terra;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import dev.terra.commands.ServerSwitcher;
import dev.terra.commands.SetTeleporters;
import dev.terra.events.PlayerJoin;
import dev.terra.events.PressurePlateEvent;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class Main extends JavaPlugin implements PluginMessageListener {

    public FileConfiguration config = getConfig();

    @Override
    public void onEnable() {

        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);

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
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if(!channel.equals("BungeeCord")) {
            return;
        }
        ByteArrayDataInput in = ByteStreams.newDataInput(message);
        String subchannel = in.readUTF();
        if(subchannel.equals("SomeSubChannel")) {

        }
    }

    @Override
    public void onDisable() {
        System.out.println("TerraServerSwitcher has stopped");
    }

}
