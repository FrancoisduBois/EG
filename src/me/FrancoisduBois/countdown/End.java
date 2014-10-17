package me.FrancoisduBois.countdown;

import me.FrancoisduBois.Main;
import org.bukkit.Bukkit;

/**
 * Created by Miklas on 13.10.2014.
 */
public class End {

    public int Count;
    public int count;

    public void CountDown(int length){
        Count = length+1;

        count = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {

                if(Count != 0){
                    Count--;
                }


            }
        }, 0L, 20L);



    }

}
