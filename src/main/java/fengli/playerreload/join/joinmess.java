package fengli.playerreload.join;

import org.bukkit.plugin.*;
import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class joinmess implements Listener
{
    private Plugin Tish;

    public joinmess(Plugin pluginMain) {
        this.Tish = pluginMain;
    }

    public String c(String s){
        return ChatColor.translateAlternateColorCodes('&',s);
    }

    public double b(double sb){
        double jf = sb;
        //利用字符串格式化的方式实现四舍五入,保留1位小数
        String result = String.format("%.1f",jf);
        jf = Double.parseDouble(result);
        //1代表小数点后面的位数, 不足补0。f代表数据是浮点类型。保留2位小数就是“%.2f”，依此累推。
        return jf;
    }

    @EventHandler
    public void OnJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        e.setJoinMessage(ChatColor.GREEN+e.getPlayer().getName()+" 加入了HiPeaksol.");
    }

    @EventHandler
    public void OnLeave(PlayerQuitEvent e){
        e.setQuitMessage(ChatColor.GREEN+e.getPlayer().getName()+" 退出了HiPeaksol.");
    }
    @EventHandler
    public void OnChat(AsyncPlayerChatEvent event){
        event.setMessage(ChatColor.translateAlternateColorCodes('&',event.getMessage()));
    }
}