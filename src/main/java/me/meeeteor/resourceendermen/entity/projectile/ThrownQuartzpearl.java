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

public class ThrownQuartzpearl extends ThrownEnderpearl {
    public ThrownQuartzpearl(Level p_37491_, Player p_37492_) {
        super(p_37491_, p_37492_);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.QUARTZ_PEARL.get();
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
                        if(this.random.nextFloat() < OptionsHolder.COMMON.quartzDropChance.get()){
                            ItemEntity quartz = EntityType.ITEM.create(this.level);
                            quartz.setItem(new ItemStack(Items.QUARTZ));
                            quartz.moveTo(entity.getX(), entity.getY(), entity.getZ(), entity.getYRot(), entity.getXRot());
                            this.level.addFreshEntity(quartz);
                        }
                    }
                }
            }
        }
    }
}
