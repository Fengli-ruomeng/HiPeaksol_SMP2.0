package fengli.playerreload.join;

import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.*;
import org.bukkit.*;
import org.bukkit.scheduler.*;
import org.bukkit.entity.*;
import org.bukkit.potion.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.util.Vector;

public class joinanddie implements Listener
{
    private Plugin Tish;

    public joinanddie(Plugin pluginMain) {
        this.Tish = pluginMain;
    }

    @EventHandler
    public void Ondead(PlayerRespawnEvent e) {
          Player player = e.getPlayer();
        player.setGameMode(GameMode.SPECTATOR);
        player.sendTitle("重建分子结构中...", "3秒后您将获得新躯体.");
        new BukkitRunnable() {
            public void run() {
                player.setGameMode(GameMode.SURVIVAL);
                player.teleport(e.getRespawnLocation());
                player.resetTitle();
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 0));
                player.sendTitle("分子结构重建成功", "享受您的新躯体", 10, 40, 20);
            }
        }.runTaskLater(this.Tish, 60L);

    }

}