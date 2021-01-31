package fengli.playerreload.command;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class shoutL implements CommandExecutor
{
    public boolean onCommand(  CommandSender sender,   Command command,   String label,   String[] args) {
        if (sender instanceof Player) {
              Player sender2 = (Player)sender;
            for (  Player player : Bukkit.getOnlinePlayers()) {
                if (player != sender2) {
                    player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + sender2.getName() + "向你们扣了大大的L LL 你就是L");
                }
            }
        }
        return false;
    }
}