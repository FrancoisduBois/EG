package me.FrancoisduBois.countdown;

import me.FrancoisduBois.GameState;
import me.FrancoisduBois.Main;
import org.bukkit.Bukkit;

/**
 * Created by Miklas on 13.10.2014.
 */
public class Grace {
    public int Count;
    public int count;
    Game game = new Game();

    public void CountDown(int length){
        Count = length+1;
        if(Main.getInstance().gs == GameState.Grace) {

            count = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    if(Count != 0){
                        Count--;
                    }else if (Count == 15||Count==10||Count==5||Count==4||Count==3||Count==2){
                        Bukkit.broadcastMessage(Main.getInstance().pr+"Das Spiel beginnt in "+Count+" Sekunden");
                    }else if (Count ==1){
                        Bukkit.broadcastMessage(Main.getInstance().pr+"Das Spiel beginnt in "+Count+" Sekunde");
                    }else if(Count==0){
                        Bukkit.getScheduler().cancelTask(count);
                        Main.getInstance().gs = GameState.Game;
                        Bukkit.broadcastMessage(Main.getInstance().pr+" Das Spiel beginnt jetzt");
                        game.CountDown(26);
                    }
                }
            }, 0L, 20L);
        }
    }

}
