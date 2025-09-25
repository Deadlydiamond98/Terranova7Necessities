package net.deadlydiamond98.datagen;

import net.deadlydiamond98.common.items.TerranovaItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class BlockBotsModelDatagen extends FabricModelProvider {

    public BlockBotsModelDatagen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(TerranovaItems.TOKEN, Models.GENERATED);
        itemModelGenerator.register(TerranovaItems.BORDER_TOKEN, Models.GENERATED);
    }
}
