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
public class Lobby {

    Spawn spawn = new Spawn();

    public int Count;
    public int count;

    public void CountDown(int length){
        Count = length +1;

        if(Main.getInstance().gs == GameState.Lobby){
            count = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    if(Bukkit.getOnlinePlayers().length >= Main.getInstance().minplayers) {
                        if (Count != 0) {
                            Count--;
                        }
                        if (Count == 50 || Count == 40 || Count == 30 || Count == 20 || Count == 15 || Count == 10 || Count == 5 || Count == 4 || Count == 3 ||
                                Count == 2 || Count == 1) {

                            Bukkit.broadcastMessage(Main.getInstance().pr + "Die Runde startet in §e" + Count + " §9Sekunden");
                            Main.getInstance().playSecondSound(Sound.ANVIL_USE);

                        } else if (Count == 0) {
                            if (Bukkit.getOnlinePlayers().length >= Main.getInstance().minplayers) {
                                Bukkit.getScheduler().cancelTask(count);
                                Bukkit.broadcastMessage(Main.getInstance().pr + "Die Runde beginnt jetzt");
                                Main.getInstance().gs = GameState.OnSpawn;
                                spawn.CountDown(20);
                                Main.getInstance().playSecondSound(Sound.ANVIL_LAND);
                            } else {
                                Bukkit.broadcastMessage(Main.getInstance().pr + "Es sind zu wenige Spieler Online");
                                Bukkit.broadcastMessage(Main.getInstance().pr + "Der CountDown wird neu getartet");
                                Count = 60;
                                Main.getInstance().playSecondSound(Sound.ANVIL_BREAK);
                            }
                        }
                    }
                }
            }, 0L, 20L);
        }

    }

}
