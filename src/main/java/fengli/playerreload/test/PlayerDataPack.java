package fengli.playerreload.test;
//以后当数据包用 先随便写一个测试
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerDataPack {
    /*
    使用需知：
    若一个包的数据想让所有人都可以用，则无视Name和UUID框内的数据
    因为每一个玩家的Name和UUID都应该是独一无二的，防止BUG.
    如果该包是玩家的，你进行了修改，想要让这个数据包只能该玩家用
    则UUID和NAME必须和那个玩家的数据完全一致,否则无法覆盖.
    不知道这个方法有什么意义，反正写上就完事了，又不亏
    有BUG会音速更新，目前该数据包类处于测试.
    */
    private double Health;
    private int FoodLevel;
    private float Saturation;
    private Location NLocation;
    private final String Name;
    private GameMode NGamemode ;
    private final UUID NUUID;
    private float Exp;
    //创建一个玩家的包
    public PlayerDataPack(Player player){
        this.Health = player.getHealth();
        this.FoodLevel = player.getFoodLevel();
        this.Saturation = player.getSaturation();
        this.NLocation = player.getLocation();
        this.Name = player.getName();
        this.NGamemode = player.getGameMode();
        this.NUUID = player.getUniqueId();
        this.Exp = player.getExp();
    }
    //自定义包,可以相当于创建了一个指定玩家的包,而数据是自定义
    //只要Name和UUID和那个玩家一致即可
    //如果是想万用包,Name和UUID请随机填入.
    public PlayerDataPack(double Health,int FoodLevel,float Saturation,Location location,String Name,GameMode gameMode,UUID UID,float Exp){
        this.Health = Health;
        this.FoodLevel = FoodLevel;
        this.Saturation = Saturation;
        this.NLocation = location;
        this.Name = Name;
        this.NGamemode = gameMode;
        this.NUUID = UID;
        this.Exp = Exp;
    }
    //覆盖(不覆盖关键信息，如名字和UID,万用包
    public void Covered_NoUid(Player player){
        player.setHealth(Health);
        player.setFoodLevel(FoodLevel);
        player.setSaturation(Saturation);
        player.teleport(NLocation);
        player.setDisplayName(Name);
        player.setGameMode(NGamemode);
        player.setExp(Exp);
    }
    //覆盖(必须Name和UUID一致，否则返回假，其他则为真.
    public boolean Covered(Player player){
        if (player.getUniqueId().equals(NUUID)) return false;
        if (!player.getName().equals(Name)) return false;
        player.setHealth(Health);
        player.setFoodLevel(FoodLevel);
        player.setSaturation(Saturation);
        player.teleport(NLocation);
        player.setGameMode(NGamemode);
        player.setExp(Exp);
        return true;
    }
    //不提供指定覆盖某样数据的功能，因为可以直接从某个包内提取数据然后直接Set.

    //set
    public void setHealth(double health) { Health = health; }

    public void setFoodLevel(int foodLevel) { FoodLevel = foodLevel; }

    public void setSaturation(float saturation) { Saturation = saturation; }

    public void setLocation(Location NLocation) { this.NLocation = NLocation; }

    //Set方法里不提供设置名字和UUID 因为这两条数据是用于判断是否为特殊私有包用

    public void setGamemode(GameMode NGamemode) { this.NGamemode = NGamemode; }

    public void setExp(float exp) { Exp = exp; }

    //get
    public double getHealth() { return Health; }

    public int getFoodLevel() { return FoodLevel; }

    public float getSaturation() { return Saturation; }

    public Location getLocation() { return NLocation; }

    public String getName() { return Name; }

    public GameMode getGamemode() { return NGamemode; }

    public UUID getUUID() { return NUUID; }

    public float getExp() { return Exp; }
}
