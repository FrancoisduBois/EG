package me.FrancoisduBois.Kits;

import me.FrancoisduBois.KitType;
import me.FrancoisduBois.Main;
import org.bukkit.entity.Player;

/**
 * Created by Miklas on 13.10.2014.
 */
public class Kits{

    public KitType getKit(Player p){
        return Main.getInstance().kits.get(p);
    }

    public void setKit(Player p, KitType type){
        Main.getInstance().kits.put(p, type);
    }
}
