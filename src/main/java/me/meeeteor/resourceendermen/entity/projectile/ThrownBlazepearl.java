package me.meeeteor.resourceendermen.entity.projectile;

import me.meeeteor.resourceendermen.OptionsHolder;
import me.meeeteor.resourceendermen.item.ModItems;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.event.entity.EntityTeleportEvent;

public class ThrownBlazepearl extends ThrownEnderpearl {
    public ThrownBlazepearl(Level p_37491_, Player p_37492_) {
        super(p_37491_, p_37492_);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.BLAZE_PEARL.get();
    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);

        if(!this.level.isClientSide){
            Entity entity = this.getOwner();
            if(entity instanceof ServerPlayer){
                ServerPlayer serverplayer = (ServerPlayer) entity;
                if(serverplayer.connection.getConnection().isConnected() && serverplayer.level == this.level && !serverplayer.isSleeping()){
                    EntityTeleportEvent.EnderPearl event = net.minecraftforge.event.ForgeEventFactory.onEnderPearlLand(serverplayer, this.getX(), this.getY(), this.getZ(), this, 5.0F);
                    if(!event.isCanceled()) { //Don't indent to lower patch size
                        if(this.random.nextFloat() < OptionsHolder.COMMON.blazeDropChance.get()){
                            ItemEntity blaze_powder = EntityType.ITEM.create(this.level);
                            blaze_powder.setItem(new ItemStack(Items.BLAZE_POWDER));
                            blaze_powder.moveTo(entity.getX(), entity.getY(), entity.getZ(), entity.getYRot(), entity.getXRot());
                            this.level.addFreshEntity(blaze_powder);
                        }
                    }
                }
            }
        }
    }
}
