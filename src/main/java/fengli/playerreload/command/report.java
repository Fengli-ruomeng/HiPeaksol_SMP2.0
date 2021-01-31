package fengli.playerreload.command;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import fengli.playerreload.nms.*;

public class report implements CommandExecutor
{
    public boolean onCommand(  CommandSender sender,   Command command,   String label,   String[] args) {
        if (sender instanceof Player) {
            if (args.length > 0) {
                  Player player = Bukkit.getPlayer(args[0]);
                if (player == null) {
                      Player player2 = (Player)sender;
                      ActBord dj = new ActBord_true();
                      String s = args[0] + "不在线.无法清理权限/举报.";
                    dj.sendActionbar(player2, s);
                }
                else if (player != null) {
                    sender.sendMessage(ChatColor.AQUA + "可,看起来这个B在线.已经发送给在线的管理员了嗷,如果没在线的,那就不关爷事了");
                    for (  Player player3 : Bukkit.getOnlinePlayers()) {
                        if (player3.isOp()) {
                            player3.sendMessage(sender.getName() + " 举报了这个铁憨憨 " + player.getName());
                            player3.sendMessage("你可以选择去激情把他下线然后清理权限[ /kick [Inf]清理权限 ]");
                            player3.sendMessage("或者加他的QQ送给他一个大大的呲牙");
                            player3.sendMessage("或者TP他把他家炸了[SB行为] , 反正宁爱咋咋地8! 因为宁是OP :D");
                        }
                    }
                }
            }
            else {
                sender.sendMessage("使用方法/report <你想举报的那个小b崽子>");
            }
        }
        return false;
    }
}