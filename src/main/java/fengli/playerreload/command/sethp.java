package fengli.playerreload.command;

import java.util.regex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.attribute.*;

public class sethp implements CommandExecutor
{
    public boolean isDouble(  String fengli) {
          Matcher toolcode = Pattern.compile("^[+-]?[0-9.]+$").matcher(fengli);
        return toolcode.find();
    }

    public boolean onCommand(  CommandSender sender,   Command command,   String label,   String[] args) {
        if (sender instanceof Player && sender.isOp()) {
            if (args.length > 0) {
                  Player player = Bukkit.getPlayerExact(args[0]);
                if (player instanceof Player) {
                    if (args.length >= 1) {
                        if (args.length == 2) {
                            if (this.isDouble(args[1])) {
                                  String fuckingHpTitle = args[1];
                                if (player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() >= Double.parseDouble(fuckingHpTitle)) {
                                      double Health = Double.parseDouble(fuckingHpTitle);
                                    player.setHealth(Health);
                                    sender.sendMessage("成功设置玩家" + player.getName() + "当前HP为" + fuckingHpTitle);
                                }
                                else {
                                    sender.sendMessage("你输入数值大于他的最大生命值!");
                                }
                            }
                            else {
                                sender.sendMessage("你需要一个double类型数值! (www.baidu.com)");
                            }
                        }
                        else {
                            sender.sendMessage("你没有设置血量!");
                        }
                    }
                    else {
                        sender.sendMessage("你没有设置血量!");
                    }
                }
                else {
                    sender.sendMessage("你只能选中在线的玩家");
                }
            }
            else {
                sender.sendMessage("使用方法:");
                sender.sendMessage("/SetHP <Player> <DoubleHeal>");
            }
        }
        return false;
    }
}