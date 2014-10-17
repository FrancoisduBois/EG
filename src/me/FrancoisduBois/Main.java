package me.FrancoisduBois;

import me.FrancoisduBois.countdown.Lobby;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Miklas on 13.10.2014.
 */
public class Main extends JavaPlugin {

    private static Main main;

    public GameState gs;
    public KitType kt;

    Lobby lobby = new Lobby();

    @Override
    public void onEnable(){
        main = this;
        gs = GameState.Lobby;
        lobby.CountDown(10);
    }

    public static Main getInstance(){
        return main;
    }

    public List<Player> Ingame = new ArrayList<Player>();
    public List<Player> Spectators = new ArrayList<Player>();

    public HashMap<Player, KitType> kits = new HashMap<Player, KitType>();

    public int minplayers = 0;

    public String pr =
         ChatColor.GRAY+"["+ChatColor.DARK_PURPLE+"EG"+ChatColor.GRAY+"] "+ChatColor.AQUA;


    public ItemStack Item(int count, int size, Material material, byte i){
        ItemStack itemStack = new ItemStack(material, size, (byte) i);
        ItemMeta imeta = itemStack.getItemMeta();
        imeta.setDisplayName(ChatColor.GREEN+""+count);
        itemStack.setItemMeta(imeta);

        return itemStack;
    }

}
