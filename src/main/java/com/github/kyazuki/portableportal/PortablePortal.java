package com.github.kyazuki.portableportal;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Rotation;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(PortablePortal.MODID)
@Mod.EventBusSubscriber
public class PortablePortal {
  public static final String MODID = "portableportal";
  public static final Logger LOGGER = LogManager.getLogger(MODID);

  public PortablePortal() {
    LOGGER.debug("Portable Portal Loaded!");
  }

  @SubscribeEvent
  public static void onPlaceNetherPortal(BlockEvent.EntityPlaceEvent event) {
    if (!event.getEntity().getEntityWorld().isRemote) {
      if (event.getPlacedBlock() == Blocks.NETHER_PORTAL.getDefaultState()) {
        if (event.getEntity() instanceof PlayerEntity) {
          PlayerEntity player = (PlayerEntity) event.getEntity();
          float yaw = player.rotationYaw;
          if ((yaw > 45.0 && yaw <= 135.0) || (yaw > 225.0 && yaw <= 315.0)) {
            event.getEntity().getEntityWorld().setBlockState(event.getPos(), Blocks.NETHER_PORTAL.getDefaultState().rotate(Rotation.CLOCKWISE_90));
          }
        }
      }
    }
  }
}
