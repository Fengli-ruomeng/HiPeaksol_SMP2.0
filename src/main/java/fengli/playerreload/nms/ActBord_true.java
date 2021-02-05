package fengli.playerreload.nms;

import org.bukkit.entity.*;
import org.json.simple.*;
import org.bukkit.craftbukkit.v1_16_R3.entity.*;
import net.minecraft.server.v1_16_R3.*;

public class ActBord_true implements ActBord
{
    @Override
    public void sendActionbar(Player p,String message) {
        JSONObject json = new JSONObject();
        json.put("text", message);
        String logDesc = json.toString();
        IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a(logDesc);
        PacketPlayOutChat bar = new PacketPlayOutChat(icbc, ChatMessageType.GAME_INFO, p.getUniqueId());
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(bar);
    }
    /*
    * 尝试玩了一下NMS
    * 此行代码目前处于BUG期
    */
    @Override
    public void healPlayer(Player p,Float f){
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(new PacketPlayOutUpdateHealth(20f,20,20));
    }
}
