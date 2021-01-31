package fengli.playerreload.event;

import fengli.playerreload.nms.ActBord;
import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.attribute.*;
import net.md_5.bungee.api.*;
import fengli.playerreload.nms.*;
import org.bukkit.event.*;

public class titledamage implements Listener
{

    double bowUseDamage = 0;

    public double Liu(double sb){
        double jf = sb;
        //利用字符串格式化的方式实现四舍五入,保留1位小数
        String result = String.format("%.1f",jf);
        jf = Double.parseDouble(result);
        //1代表小数点后面的位数, 不足补0。f代表数据是浮点类型。保留2位小数就是“%.2f”，依此累推。
        return jf;
    }

    @EventHandler
    public void onUseItem(EntityDamageByEntityEvent e) {

        if (e.getDamager() instanceof Arrow){
            bowUseDamage = e.getDamage();
        }

        if (e.getDamager() instanceof Player) {
            Player player = (Player)e.getDamager();
            if (e.getEntity() instanceof Player) {
                ActBord actBord = new ActBord_true();
                double EntityMaxHP = ((Player) e.getEntity()).getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
                double realheal = Liu(((Player) e.getEntity()).getHealth() - e.getFinalDamage());

                if (realheal <= 0){
                    actBord.sendActionbar(player, ChatColor.RED+"§o§m"+ e.getEntity().getName() + ChatColor.WHITE+ " [" + ChatColor.RED + "DEAD" + ChatColor.WHITE + "/" + ChatColor.GREEN + EntityMaxHP + ChatColor.WHITE + "] " + ChatColor.DARK_RED + Liu(e.getFinalDamage()) + "X");
                    return;
                }

                if (realheal < 10) {
                    actBord.sendActionbar(player, e.getEntity().getName() + " [" + ChatColor.RED + realheal + ChatColor.WHITE + "/" + ChatColor.GREEN + EntityMaxHP + ChatColor.WHITE + "] " + ChatColor.AQUA + Liu(e.getFinalDamage()) + "❤");
                } else {
                    actBord.sendActionbar(player, e.getEntity().getName() + " [" + ChatColor.AQUA + realheal + ChatColor.WHITE + "/" + ChatColor.GREEN + EntityMaxHP + ChatColor.WHITE + "] " + ChatColor.AQUA + Liu(e.getFinalDamage()) + "❤");
                }
            }else if (e.getEntity() instanceof LivingEntity){
                LivingEntity livingEntity = (LivingEntity) e.getEntity();

                ActBord actBord = new ActBord_true();
                double EntityMaxHP = livingEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
                double realheal = Liu(livingEntity.getHealth() - e.getFinalDamage());

                if (realheal <= 0){
                    actBord.sendActionbar(player, ChatColor.RED+"§o§m"+ e.getEntity().getName() + ChatColor.WHITE+ " [" + ChatColor.RED + "DEAD" + ChatColor.WHITE + "/" + ChatColor.GREEN + EntityMaxHP + ChatColor.WHITE + "] " + ChatColor.DARK_RED + Liu(e.getFinalDamage()) + "X");
                    return;
                }

                if (realheal < 10) {
                    actBord.sendActionbar(player, e.getEntity().getName() + " [" + ChatColor.RED + realheal + ChatColor.WHITE + "/" + ChatColor.GREEN + EntityMaxHP + ChatColor.WHITE + "] " + ChatColor.AQUA + Liu(e.getFinalDamage()) + "❤");
                } else {
                    actBord.sendActionbar(player, e.getEntity().getName() + " [" + ChatColor.AQUA + realheal + ChatColor.WHITE + "/" + ChatColor.GREEN + EntityMaxHP + ChatColor.WHITE + "] " + ChatColor.AQUA + Liu(e.getFinalDamage()) + "❤");
                }

            }
        }
    }
}