package fengli.playerreload.command;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.attribute.*;

public class food implements CommandExecutor
{
    public boolean onCommand(  CommandSender sender,   Command command,   String label,   String[] args) {
          Player player = (Player)sender;
          String Fengli = "Fengli_ruomeng";
        if (sender instanceof Player) {
            if (Fengli.equals(player.getName())) {
                player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                player.setFoodLevel(20);
                player.setSaturation(20.0f);
            }
            else {
                player.sendMessage("你不是 [开发者] Fengli_ruomeng! 无法使用作弊指令!");
            }
        }
        else {
            System.out.print("爬");
        }
        return false;
    }
}