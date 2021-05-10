package dev.terra.events;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import dev.terra.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PressurePlateEvent implements Listener {

    private final Main main;

    public PressurePlateEvent(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onSurvivalTeleporter(PlayerMoveEvent event) {

        if((event.getTo().getBlock().getX() + " " + event.getTo().getBlock().getY() + " " + event.getTo().getBlock().getZ()).equals(main.config.getString("SurvivalTeleporter"))) {
            //Bukkit.dispatchCommand(event.getPlayer(), "smp");
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("Connect");
            out.writeUTF("survival");

            Player player = event.getPlayer();
            player.sendPluginMessage(this.main, "BungeeCord", out.toByteArray());

            //event.getPlayer().performCommand("server survival");
        }

    }

    @EventHandler
    public void onSpleefTeleporter(PlayerMoveEvent event) {
        if((event.getTo().getBlock().getX() + " " + event.getTo().getBlock().getY() + " " + event.getTo().getBlock().getZ()).equals(main.config.getString("SpleefTeleporter"))) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp " + event.getPlayer().getName() + " 1000 206 1000");
        }
    }

}
