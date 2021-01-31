package fengli.playerreload.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

public class EditItem implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!(commandSender instanceof Player)){
            return false;
        }
        Player player = (Player) commandSender;
        if (strings.length > 0){

            if (strings[0].equalsIgnoreCase("rename")){

                ItemStack itemStack = player.getInventory().getItemInMainHand();
                ItemMeta itemMeta = itemStack.getItemMeta();
                if (strings.length > 1 && strings[1] != null){
                    itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',strings[1]));
                    itemStack.setItemMeta(itemMeta);
                    return true;
                }

            }


        }


        return false;

    }
}
