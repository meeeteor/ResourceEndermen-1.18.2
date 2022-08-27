package me.meeeteor.resourceendermen.entity.projectile;

import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.event.entity.EntityTeleportEvent;

public class ThrownDiamondpearl extends ThrownEnderpearl {
    public ThrownDiamondpearl(Level p_37491_, Player p_37492_) {
        super(p_37491_, p_37492_);
    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);

        if(!this.level.isClientSide && !this.isRemoved()){
            Entity entity = this.getOwner();
            if(entity instanceof ServerPlayer){
                ServerPlayer serverplayer = (ServerPlayer) entity;
                if(serverplayer.connection.getConnection().isConnected() && serverplayer.level == this.level && !serverplayer.isSleeping()){
                    EntityTeleportEvent.EnderPearl event = net.minecraftforge.event.ForgeEventFactory.onEnderPearlLand(serverplayer, this.getX(), this.getY(), this.getZ(), this, 5.0F);
                    if(!event.isCanceled()) { //Don't indent to lower patch size
                    this.getOwner().sendMessage(new TextComponent("Will you get a diamond?"),this.getOwner().getUUID()); //this doesn't run
                    if(this.random.nextFloat() < 0.5F){
                        ItemEntity diamond = EntityType.ITEM.create(this.level);
                        diamond.setItem(new ItemStack(Items.DIAMOND));
                        diamond.moveTo(entity.getX(), entity.getY(), entity.getZ(), entity.getYRot(), entity.getXRot());
                        this.level.addFreshEntity(diamond);
                        entity.sendMessage(new TextComponent("You got a diamond!"), entity.getUUID()); //this doesn't run
                    }
                    }
                }
            }
        }


        this.getOwner().sendMessage(new TextComponent("pearl landed"), this.getOwner().getUUID()); //this works

    }
}
