package net.deadlydiamond98;

import net.deadlydiamond98.common.items.TerranovaItems;
import net.deadlydiamond98.koalalib.config.KoalaConfigCreator;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Terranova implements ModInitializer {
	public static final String MOD_ID = "terranova777nec";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		KoalaConfigCreator.addModConfig(MOD_ID, TerranovaConfig.class);
		TerranovaItems.register();
	}
}