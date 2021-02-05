package fengli.playerreload.command.ReportData;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class ReportLib {

    static HashMap<Player,String> Lib;

    public static HashMap<Player, String> getLib() {
        return Lib;
    }

    /*
    懒得加检查方法了.
    所以便给add方法和remove方法加入了
    boolean的判断.
    用的时候直接用就可以了.
    */

    public static boolean addLib(Player reporter,String what) {
        if (Lib.containsKey(reporter)) {
            Lib.replace(reporter, what);
            return false;
        } else {
            Lib.put(reporter, what);
            return true;
        }
    }

    /*
    主要也是怕出BUG
    虽然就我一个人用
    但是看得舒服就完事了
    */

    public static boolean removeLib(Player reporter) {
        if (!Lib.containsKey(reporter)) {
            return false;
        } else {
            Lib.remove(reporter);
            return true;
        }
    }

    public static String getLib(Player reporter) {
        if (Lib.containsKey(reporter)){
            return Lib.get(reporter);
        }else return null;
    }

    /*
    这终归还是一个data类
    存数据用的

    暂时没有写类的想法
    */



    static {
        Lib = new HashMap<>();
    }
}
