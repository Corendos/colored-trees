package com.corendos.colored_trees.proxies;

import com.corendos.colored_trees.ColoredTrees;
import com.corendos.colored_trees.block.BlockColoredLeaves;
import com.corendos.colored_trees.block.BlockColoredSapling;
import com.corendos.colored_trees.init.ModBlocks;
import com.corendos.colored_trees.init.ModItems;
import com.corendos.colored_trees.item.ItemColoredLeaves;
import com.corendos.colored_trees.item.ItemColoredSapling;
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
            BlockColoredLeaves blockColoredLeaves = new BlockColoredLeaves(i);
            blockColoredLeaves.setGraphicsLevel(true);
            ModBlocks.blocks_colored_leaves.add(blockColoredLeaves);
            ModItems.items_colored_leaves.add(new ItemColoredLeaves(blockColoredLeaves));

            BlockColoredSapling blockColoredSapling = new BlockColoredSapling(i);
            ModBlocks.blocks_colored_sapling.add(blockColoredSapling);
            ModItems.items_colored_sapling.add(new ItemColoredSapling(blockColoredSapling));
        }
    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        ColoredTrees.logger.info("Registering Blocks");
        for (int i = 0;i < 16;++i) {
            event.getRegistry().register(ModBlocks.blocks_colored_sapling.get(i));
            event.getRegistry().register(ModBlocks.blocks_colored_leaves.get(i));
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        ColoredTrees.logger.info("Registering Items");
        for (int i = 0;i < 16;++i) {
            event.getRegistry().register(ModItems.items_colored_sapling.get(i));
            event.getRegistry().register(ModItems.items_colored_leaves.get(i));
        }
    }
}
