package fengli.playerreload.command.ReportData;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReportMenu implements CommandExecutor {

    public String a(String s){
        return ChatColor.translateAlternateColorCodes('&',s);
    }

    public Inventory GetInv(){
        
        Inventory RMenu = Bukkit.createInventory(null,54,a("&bHi &aPeaksol &fReport Menu"));
        
        for (Map.Entry<Player,String> Lib : ReportLib.Lib.entrySet()){
            
            if (RMenu.getItem(53) != null){
                RMenu.clear();
            }
            
            ItemStack itemStack = new ItemStack(Material.BOOK);
            ItemMeta itemMeta = itemStack.getItemMeta();
            
            itemMeta.setDisplayName(a("&a"+Lib.getKey().getDisplayName()+"举报"));
            
            ArrayList<String> a = new ArrayList<>();
            a.add(ChatColor.GRAY+"原因:");
            a.add(ChatColor.GOLD+Lib.getValue());
            
            itemMeta.setLore(a);
            itemStack.setItemMeta(itemMeta);
            
            RMenu.addItem(itemStack);
        }
        return RMenu;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender cs, @NotNull Command com, @NotNull String s, @NotNull String[] args) {
        if (cs instanceof Player){
            if (args.length > 0){
                if (args[0].equals("clear")){
                    if (cs.isOp()){
                        ReportLib.Lib = new HashMap<>();
                        return true;
                    }else ((Player) cs).openInventory(GetInv());
                }else ((Player) cs).openInventory(GetInv());
            }
            if (cs.isOp()){
                ((Player) cs).openInventory(GetInv());
            }
        }
        return false;
    }

}
