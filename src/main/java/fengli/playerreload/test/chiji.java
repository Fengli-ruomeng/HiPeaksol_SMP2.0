package fengli.playerreload.test;

import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.attribute.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class chiji implements Listener
{
    @EventHandler
    public void HealChink(  PlayerItemConsumeEvent e) {
          Player player = e.getPlayer();
        if (e.getItem().getType() != Material.COOKED_CHICKEN) {
            return;
        }
        if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("CookBool")) {
            player.setFoodLevel(18);
        }
          double one = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() - 5.0;
        if (player.getHealth() <= one) {
            player.setHealth(player.getHealth() + 5.0);
        }
        else if (player.getHealth() > one) {
              double hp = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() - player.getHealth();
            player.setHealth(player.getHealth() + hp);
        }
    }
}
