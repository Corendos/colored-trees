package com.corendos.colored_trees.proxies;

import com.corendos.colored_trees.ColoredTrees;
import com.corendos.colored_trees.block.BlockColoredLeaves;
import com.corendos.colored_trees.init.ModBlocks;
import com.corendos.colored_trees.init.ModItems;
import com.corendos.colored_trees.item.ItemColoredLeaves;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        for (int i = 0;i < 16;++i) {
            BlockColoredLeaves block = new BlockColoredLeaves(i);
            block.setGraphicsLevel(true);
            ModBlocks.blocks_colored_leaves.add(block);
            ModItems.items_colored_leaves.add(new ItemColoredLeaves(block));
        }
    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        ColoredTrees.logger.info("Registering Blocks");
        event.getRegistry().register(ModBlocks.block_colored_sapling);
        for (int i = 0;i < 16;++i) {
            event.getRegistry().register(ModBlocks.blocks_colored_leaves.get(i));
        }
        /*event.getRegistry().register(ModBlocks.block_orange_colored_leaves);
        event.getRegistry().register(ModBlocks.block_magenta_colored_leaves);
        event.getRegistry().register(ModBlocks.block_light_blue_colored_leaves);
        event.getRegistry().register(ModBlocks.block_yellow_colored_leaves);
        event.getRegistry().register(ModBlocks.block_lime_colored_leaves);
        event.getRegistry().register(ModBlocks.block_pink_colored_leaves);
        event.getRegistry().register(ModBlocks.block_gray_colored_leaves);
        event.getRegistry().register(ModBlocks.block_silver_colored_leaves);
        event.getRegistry().register(ModBlocks.block_cyan_colored_leaves);
        event.getRegistry().register(ModBlocks.block_purple_colored_leaves);
        event.getRegistry().register(ModBlocks.block_blue_colored_leaves);
        event.getRegistry().register(ModBlocks.block_brown_colored_leaves);
        event.getRegistry().register(ModBlocks.block_green_colored_leaves);
        event.getRegistry().register(ModBlocks.block_red_colored_leaves);
        event.getRegistry().register(ModBlocks.block_black_colored_leaves);*/
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        ColoredTrees.logger.info("Registering Items");
        event.getRegistry().register(ModItems.item_colored_sapling);
        for (int i = 0;i < 16;++i) {
            event.getRegistry().register(ModItems.items_colored_leaves.get(i));
        }
    }
}
