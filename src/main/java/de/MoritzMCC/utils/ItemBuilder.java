package de.MoritzMCC.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

public class ItemBuilder {
    ItemStack itemStack;
    ItemMeta itemMeta;


    public ItemBuilder(Material material){
        itemStack = new ItemStack(material);
        itemMeta = itemStack.getItemMeta();
    }

    public ItemBuilder withName(String name){
        itemMeta.setDisplayName(name);
        return this;
    }

    public ItemBuilder withAmount(int amount){
        itemStack.setAmount(amount);
        return this;
    }

    public ItemBuilder withLore(String...lore){
        itemMeta.setLore(Arrays.asList(lore));
        return this;
    }
    public ItemBuilder setUnbreakable(boolean unbreakable) {
        itemMeta.setUnbreakable(unbreakable);
        return this;
    }
    public ItemBuilder setPlayerSkull(String name) {
        SkullMeta skullMeta = (SkullMeta) itemMeta;
        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(name));
        return this;
    }
    public ItemBuilder setEnchantment(Enchantment enchantment, int lvl) {
        itemMeta.addEnchant(enchantment, lvl, true);
        return this;
    }

    public ItemStack build(){
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
