package com.corendos.colored_trees.proxies;

import com.corendos.colored_trees.ColoredTrees;
import com.corendos.colored_trees.init.ModBlocks;
import com.corendos.colored_trees.init.ModItems;
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

    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        ColoredTrees.logger.info("Registering Blocks");
        event.getRegistry().register(ModBlocks.block_colored_sapling);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        ColoredTrees.logger.info("Registering Items");
        event.getRegistry().register(ModItems.item_colored_sapling);
    }
}
