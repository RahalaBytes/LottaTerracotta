package org.villainy.lottaterracotta;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.villainy.lottaterracotta.blocks.*;
import org.villainy.lottaterracotta.config.ConfigHelper;
import org.villainy.lottaterracotta.config.ConfigHolder;
import org.villainy.lottaterracotta.config.FlagRecipeCondition;
import org.villainy.lottaterracotta.items.helper.BlockItemHelper;
import org.villainy.lottaterracotta.proxy.ClientProxy;
import org.villainy.lottaterracotta.proxy.IProxy;
import org.villainy.lottaterracotta.proxy.CommonProxy;

import java.util.stream.Stream;

@Mod("lottaterracotta")
public class LottaTerracotta
{
    public static final String MODID = "lottaterracotta";

    public static final String CHANNEL = MODID;
    private static final String PROTOCOL_VERSION = "1.0";

    public static IProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);

    private static final Logger LOG = LogManager.getLogger();

    public LottaTerracotta() {
        final ModLoadingContext modLoadingContext = ModLoadingContext.get();

        modLoadingContext.registerConfig(ModConfig.Type.COMMON, ConfigHolder.COMMON_SPEC);

        CraftingHelper.register(new FlagRecipeCondition.Serializer(new ResourceLocation(LottaTerracotta.MODID, "flag")));

        FMLJavaModLoadingContext.get().getModEventBus().addListener(proxy::onFMLClientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(proxy::onFMLCommonSetup);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    private void loadComplete(final FMLLoadCompleteEvent event)
    {
        proxy.init();
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            final IForgeRegistry<Block> blockRegistry = event.getRegistry();

            Stream.of(DyeColor.values()).forEach(dyeColor -> {
                TerracottaSlabBlock slab = new TerracottaSlabBlock(dyeColor);

                blockRegistry.register(slab);
                blockRegistry.register(new TerracottaStairsBlock(dyeColor, slab.defaultBlockState()));
                blockRegistry.register(new TerracottaWallBlock(dyeColor));
                blockRegistry.register(new TerracottaButtonBlock(dyeColor));
                blockRegistry.register(new TerracottaPressurePlateBlock(dyeColor));
                blockRegistry.register(new TerracottaFenceBlock(dyeColor));
                blockRegistry.register(new TerracottaFenceGateBlock(dyeColor));
                blockRegistry.register(new TerracottaLadderBlock(dyeColor));
                blockRegistry.register(new TerracottaLeverBlock(dyeColor));
                blockRegistry.register(new TerracottaVerticalSlabBlock(dyeColor));
                blockRegistry.register(new GlazedTerracottaTileBlock(dyeColor));
                blockRegistry.register(new GlazedTerracottaSlabBlock(dyeColor));
            });

            // Register uncolored versions
            TerracottaSlabBlock slab = new TerracottaSlabBlock();
            blockRegistry.register(slab);
            blockRegistry.register(new TerracottaStairsBlock(slab.defaultBlockState()));
            blockRegistry.register(new TerracottaWallBlock());
            blockRegistry.register(new TerracottaButtonBlock());
            blockRegistry.register(new TerracottaPressurePlateBlock());
            blockRegistry.register(new TerracottaFenceBlock());
            blockRegistry.register(new TerracottaFenceGateBlock());
            blockRegistry.register(new TerracottaLadderBlock());
            blockRegistry.register(new TerracottaLeverBlock());
            blockRegistry.register(new TerracottaVerticalSlabBlock());
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            final IForgeRegistry<Item> itemRegistry = event.getRegistry();

            TerracottaSlabBlock.allBlocks().forEach (block ->
                    itemRegistry.register(BlockItemHelper.createBasicBlockItem(block, CreativeModeTab.TAB_BUILDING_BLOCKS))
            );
            TerracottaStairsBlock.allBlocks().forEach (block ->
                    itemRegistry.register(BlockItemHelper.createBasicBlockItem(block, CreativeModeTab.TAB_BUILDING_BLOCKS))
            );
            TerracottaWallBlock.allBlocks().forEach (block ->
                    itemRegistry.register(BlockItemHelper.createBasicBlockItem(block, CreativeModeTab.TAB_DECORATIONS))
            );
            TerracottaButtonBlock.allBlocks().forEach (block ->
                    itemRegistry.register(BlockItemHelper.createBasicBlockItem(block, CreativeModeTab.TAB_REDSTONE))
            );
            TerracottaPressurePlateBlock.allBlocks().forEach (block ->
                    itemRegistry.register(BlockItemHelper.createBasicBlockItem(block, CreativeModeTab.TAB_REDSTONE))
            );
            TerracottaFenceBlock.allBlocks().forEach (block ->
                    itemRegistry.register(BlockItemHelper.createBasicBlockItem(block, CreativeModeTab.TAB_DECORATIONS))
            );
            TerracottaFenceGateBlock.allBlocks().forEach (block ->
                    itemRegistry.register(BlockItemHelper.createBasicBlockItem(block, CreativeModeTab.TAB_DECORATIONS))
            );
            TerracottaLadderBlock.allBlocks().forEach (block ->
                    itemRegistry.register(BlockItemHelper.createBasicBlockItem(block, CreativeModeTab.TAB_DECORATIONS))
            );
            TerracottaLeverBlock.allBlocks().forEach (block ->
                    itemRegistry.register(BlockItemHelper.createBasicBlockItem(block, CreativeModeTab.TAB_REDSTONE))
            );
            TerracottaVerticalSlabBlock.allBlocks().forEach (block ->
                    itemRegistry.register(BlockItemHelper.createBasicBlockItem(block, CreativeModeTab.TAB_BUILDING_BLOCKS))
            );
            GlazedTerracottaTileBlock.allBlocks().forEach (block ->
                    itemRegistry.register(BlockItemHelper.createBasicBlockItem(block, CreativeModeTab.TAB_DECORATIONS))
            );
            GlazedTerracottaSlabBlock.allBlocks().forEach (block ->
                    itemRegistry.register(BlockItemHelper.createBasicBlockItem(block, CreativeModeTab.TAB_DECORATIONS))
            );
        }

        @SubscribeEvent
        public static void onModConfigEvent(final ModConfigEvent.Loading event) {
            final ModConfig config = event.getConfig();
            if (config.getSpec() == ConfigHolder.COMMON_SPEC) {
                ConfigHelper.bakeCommon(config);
            }
        }
    }
}
