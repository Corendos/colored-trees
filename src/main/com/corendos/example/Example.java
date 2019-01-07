package com.corendos.example;

import com.corendos.example.block.NewBlock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Example.MODID, name = Example.NAME, version = Example.VERSION)
@Mod.EventBusSubscriber
public class Example {
    public static final String MODID = "example";
    public static final String NAME = "Example";
    public static final String VERSION = "1.0";

    private Logger logger;
    private NewBlock newBlock;

    public Example() {
        newBlock = new NewBlock();
        MinecraftForge.EVENT_BUS.register(this);
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info("PreInit");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("Init");
    }


    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        logger.info("Registering Blocks");
        event.getRegistry().register(newBlock);
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        logger.info("Registering Items");
        event.getRegistry().register(newBlock.getItemBlock());
    }

    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        logger.info("Registering Models");
        ModelLoader.setCustomModelResourceLocation(newBlock.getItemBlock(), 0,
                new ModelResourceLocation(newBlock.getRegistryName(), "inventory"));
    }
}
