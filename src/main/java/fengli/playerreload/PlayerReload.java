package fengli.playerreload;

import fengli.playerreload.command.*;
import fengli.playerreload.event.titledamage;
import fengli.playerreload.join.joinanddie;
import fengli.playerreload.join.joinmess;
import fengli.playerreload.test.chiji;
import org.bukkit.plugin.java.JavaPlugin;


public final class PlayerReload extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getLogger().info("欢迎使用HiPeaksolSMP插件");

        this.getCommand("food").setExecutor(new food());
        this.getCommand("getfuckingop").setExecutor(new getop());
        this.getCommand("SetHP").setExecutor(new sethp());
        this.getCommand("report").setExecutor(new report());
        this.getCommand("ShoutL").setExecutor(new shoutL());
        this.getCommand("EditItem").setExecutor(new EditItem());
        this.getCommand("ReportMenu").setExecutor(new ReportMenu());

        this.getServer().getPluginManager().registerEvents(new titledamage(), this);
        this.getServer().getPluginManager().registerEvents(new joinmess(this), this);
        /*
        临时禁用测试功能
        this.getServer().getPluginManager().registerEvents(new chiji(), this);
        删除后门
        */
        this.getServer().getPluginManager().registerEvents(new joinanddie(this), this);

    }

    @Override
    public void onDisable() { }
}
