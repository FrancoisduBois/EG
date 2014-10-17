package me.FrancoisduBois;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import sun.org.mozilla.javascript.internal.Kit;

/**
 * Created by Miklas on 13.10.2014.
 */
public class KitInventory {

    public KitInventory(){

        BogenMeta.setDisplayName(ChatColor.GOLD+"Kit: §3"+ KitType.BogenSchütze.toString());
        Bogen.setItemMeta(BogenMeta);

        AxtMeta.setDisplayName("§6Kit: §3"+KitType.HolzFäller.toString());
        HolzAxt.setItemMeta(AxtMeta);

        JägerMeta.setDisplayName("§6Kit: §3"+KitType.Jäger.toString());
        JägerSchwert.setItemMeta(JägerMeta);

    }

    ItemStack Bogen = new ItemStack(Material.BOW);
    ItemMeta BogenMeta = Bogen.getItemMeta();

    ItemStack HolzAxt = new ItemStack(Material.WOOD_AXE);
    ItemMeta AxtMeta = Bogen.getItemMeta();

    ItemStack JägerSchwert = new ItemStack(Material.STONE_SWORD);
    ItemMeta JägerMeta = Bogen.getItemMeta();

}
