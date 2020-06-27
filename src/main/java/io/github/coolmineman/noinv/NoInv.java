package io.github.coolmineman.noinv;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class NoInv implements ModInitializer {
	public static final Item BLOCKER_ITEM = new Item(new Item.Settings().group(ItemGroup.MISC));

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("noinv", "blocker_item"), BLOCKER_ITEM);
	}
}
