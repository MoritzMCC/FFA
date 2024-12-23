package de.MoritzMCC.kits;

import de.hglabor.plugins.kitapi.kit.AbstractKit;
import de.hglabor.plugins.kitapi.player.KitPlayer;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;


public class AnchorKit extends AbstractKit {


    public AnchorKit(String name, Material material) {
           super(name, material);

    }

    @Override
    public void onPlayerAttacksLivingEntity(EntityDamageByEntityEvent event, KitPlayer attacker, LivingEntity entity) {
        entity.setVelocity(new Vector(0,0,0));
    }
}
