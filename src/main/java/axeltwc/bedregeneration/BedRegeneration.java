package axeltwc.bedregeneration;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public final class BedRegeneration extends JavaPlugin implements Listener{

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    @EventHandler
    public void onPlayerBedEnter(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();
        if (event.getBedEnterResult() == PlayerBedEnterEvent.BedEnterResult.OK) {
            player.getWorld().spawnParticle(Particle.HEART, event.getBed().getLocation().add(1, 1, 0), 1);
            player.getWorld().spawnParticle(Particle.HEART, event.getBed().getLocation().add(0, 1, 1), 1);
            player.getWorld().spawnParticle(Particle.HEART, event.getBed().getLocation().add(1, 1, 1), 1);
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 0));
        }
    }

    @EventHandler
    public void onPlayerBedLeave(PlayerBedLeaveEvent event) {
        Player player = event.getPlayer();
        player.removePotionEffect(PotionEffectType.REGENERATION);
    }
}
