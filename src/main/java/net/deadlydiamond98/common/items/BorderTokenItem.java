package net.deadlydiamond98.common.items;

import net.deadlydiamond98.TerranovaConfig;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.border.WorldBorder;

public class BorderTokenItem extends Item {
    public BorderTokenItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient()) {
            MinecraftServer server = world.getServer();

            world.getPlayers().forEach(player -> player.sendMessage(
                    Text.translatable("item.terranova777nec.border_token.msg", TerranovaConfig.increase, user.getName())
                            .formatted(Formatting.YELLOW)
            ));

            WorldBorder worldBorder = server.getOverworld().getWorldBorder();
            worldBorder.setSize(worldBorder.getSize() + TerranovaConfig.increase);

            stack.decrement(1);
        }
        return TypedActionResult.success(stack);
    }
}
