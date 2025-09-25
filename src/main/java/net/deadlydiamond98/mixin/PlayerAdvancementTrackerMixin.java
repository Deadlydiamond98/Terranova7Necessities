package net.deadlydiamond98.mixin;

import net.deadlydiamond98.TerranovaConfig;
import net.deadlydiamond98.common.items.TerranovaItems;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementDisplay;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.PlayerAdvancementTracker;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(PlayerAdvancementTracker.class)
public class PlayerAdvancementTrackerMixin {
    @Shadow private ServerPlayerEntity owner;

    @Inject(method = "grantCriterion", at = @At(value = "INVOKE", target = "Lnet/minecraft/advancement/Advancement;rewards()Lnet/minecraft/advancement/AdvancementRewards;"))
    private void terranova$grantCriterion(AdvancementEntry advancement, String criterionName, CallbackInfoReturnable<Boolean> cir) {
        Optional<AdvancementDisplay> display = advancement.value().display();
        if (display.isPresent()) {
            int count = display.get().getFrame().asString().equals("challenge") ? TerranovaConfig.tokenGoal : TerranovaConfig.tokenReg;
            owner.getWorld().spawnEntity(new ItemEntity(owner.getWorld(), owner.getX(), owner.getY(), owner.getZ(), new ItemStack(TerranovaItems.TOKEN, count)));
        }
    }
}
