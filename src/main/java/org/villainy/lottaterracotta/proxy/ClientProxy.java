package org.villainy.lottaterracotta.proxy;

import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.villainy.lottaterracotta.blocks.TerracottaLadderBlock;

public class ClientProxy implements IProxy {

    @Override
    public void init() {
    }

    @Override
    public void onFMLClientSetup(FMLClientSetupEvent event) {
        setRenderTypes(event);
    }

    @Override
    public void onFMLCommonSetup(FMLCommonSetupEvent event) { }

    public void setRenderTypes(final FMLClientSetupEvent event)
    {
        TerracottaLadderBlock.allBlocks().forEach (block -> {
//            RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
        });
    }
}
