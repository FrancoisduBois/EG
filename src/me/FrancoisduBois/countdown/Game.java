package me.FrancoisduBois.countdown;

import me.FrancoisduBois.GameState;
import me.FrancoisduBois.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;

/**
 * Created by Miklas on 13.10.2014.
 */
public class Game {

    public int Count;
    public int count;

    public void CountDown(int length){
        Count = length+1;

        if(Main.getInstance().gs == GameState.Game){
            count = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {

                    if(Count != 0){
                        Count--;
                    }else if (Count == 60||Count==50||Count==30||Count==20||Count==10){
                        Bukkit.broadcastMessage(Main.getInstance().pr+"Das DeathMatch beginnt in "+Count+" Sekunden");
                        Main.getInstance().playSecondSound(Sound.PISTON_EXTEND);
                    }else if(Count <= 5){
                        Bukkit.broadcastMessage(Main.getInstance().pr+"Das DeathMatch beginnt in "+Count+" Sekunden");
                        Main.getInstance().playSecondSound(Sound.PISTON_EXTEND);
                    }else if(Count == 0){
                        Bukkit.broadcastMessage(Main.getInstance().pr+"Das DeathMatch beginnt jetzt!");
                        Main.getInstance().playSecondSound(Sound.PISTON_EXTEND);
                    }
                }
            }, 0L, 20L);
        }
    }

}
