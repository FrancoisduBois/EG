package me.FrancoisduBois.countdown;

import me.FrancoisduBois.GameState;
import me.FrancoisduBois.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

/**
 * Created by Miklas on 13.10.2014.
 */
public class Spawn {

    public int Count;
    public int count;
    Grace grace = new Grace();

    public void CountDown(int length){
        Count = length;

        if(Main.getInstance().gs == GameState.OnSpawn){
            count = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {


                    if(Count != 0){
                        Count--;
                    }
                    for(Player all : Bukkit.getOnlinePlayers()){
                        all.getInventory().setItem(4, Main.getInstance().Item(Count, 0, Material.WOOL, (byte)0));
                    }
                    if(Count == 20||Count==15||Count==10||Count==5||Count==4||Count==3||Count==2||Count==1){
                        Bukkit.broadcastMessage(Main.getInstance().pr+"Das Spiel beginnt in "+Count+" Sekunden");
                        for(Player all : Bukkit.getOnlinePlayers()){
                            all.playSound(all.getLocation(), Sound.NOTE_PIANO, 30F, 30F);
                            all.getInventory().setItem(4, Main.getInstance().Item(Count, Count, Material.WOOL, (byte)14));
                        }
                    }else if (Count == 0){
                        Bukkit.getScheduler().cancelTask(count);
                        Bukkit.getScheduler().cancelAllTasks();
                        for(Player all : Bukkit.getOnlinePlayers()){
                            all.playSound(all.getLocation(), Sound.ENDERMAN_SCREAM, 30F, 30F);
                            all.getInventory().clear();
                            //Kits setzten
                            Main.getInstance().gs = GameState.Grace;
                            grace.CountDown(16);
                        }
                    }
                }
            }, 0L, 20L);
        }

    }

}
