package com.github.kyazuki.portableportal;

import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistryEntry;

@Mod.EventBusSubscriber(modid = PortablePortal.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegisterItems {
  public static BlockItem NETHER_PORTAL;
  public static BlockItem END_PORTAL;

  public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
    return setup(entry, new ResourceLocation(PortablePortal.MODID, name));
  }

  public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
    entry.setRegistryName(registryName);
    return entry;
  }

  @SubscribeEvent
  public static void onRegisterItem(RegistryEvent.Register<Item> event) {
    event.getRegistry().registerAll(
            setup(NETHER_PORTAL = new BlockItem(Blocks.NETHER_PORTAL, new Item.Properties()), "nether_portal"),
            setup(END_PORTAL = new BlockItem(Blocks.END_PORTAL, new Item.Properties()), "end_portal")
    );
  }
}
