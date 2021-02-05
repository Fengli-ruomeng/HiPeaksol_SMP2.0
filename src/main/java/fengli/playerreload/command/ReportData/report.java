package fengli.playerreload.command.ReportData;

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
                    return false;
                }
                if(args[1] == null){
                    Player player2 = (Player)sender;
                    ActBord dj = new ActBord_true();
                    String s = "你并没有填入举报内容!";
                    dj.sendActionbar(player2,s);
                    return false;
                }
                sender.sendMessage("你的举报诉求已经发送.");
                ReportLib.addLib(((Player) sender),args[1]);
            }
            else {
                sender.sendMessage("使用方法/report <举报人> <原因>");
            }
        }
        return false;
    }
}