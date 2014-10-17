package me.FrancoisduBois.countdown;

import me.FrancoisduBois.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;

/**
 * Created by Miklas on 13.10.2014.
 */
public class DeathMatch {

    public int count;
    public int Count;

    public void CountDown(int length){
        count = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                if(Count!= 0){
                    Count--;
                }
                if(Count==20*60*5||Count==20*60*4||Count==20*60*3||Count==20*60*2){
                    Bukkit.broadcastMessage(Main.getInstance().pr+"Das DeathMatch endet in "+Count+" Minuten");
                    Main.getInstance().playSecondSound(Sound.PISTON_EXTEND);
                }else if(Count ==60||Count==50||Count==40||Count==30||Count==20||Count==10
                        ||Count==5||Count==4||Count==3||Count==2){
                    Bukkit.broadcastMessage(Main.getInstance().pr+"Das DeathMatch endet in "+Count+" Sekunden");
                    Main.getInstance().playSecondSound(Sound.PISTON_EXTEND);
                }else if(Count==1){
                    Bukkit.broadcastMessage(Main.getInstance().pr+"Das DeathMatch endet in "+Count+" Sekunde");
                    Main.getInstance().playSecondSound(Sound.PISTON_EXTEND);

                }
            }
        }, 0L, 20L);
    }

}
