package com.corendos.colored_trees;

import com.corendos.colored_trees.proxies.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = ColoredTrees.MODID, name = ColoredTrees.NAME, version = ColoredTrees.VERSION, useMetadata = true)
@Mod.EventBusSubscriber
public class ColoredTrees {
    public static final String MODID = "colored_trees";
    public static final String NAME = "ColoredTrees";
    public static final String VERSION = "1.0";

    @SidedProxy(
            clientSide = "com.corendos.colored_trees.proxies.ClientProxy",
            serverSide = "com.corendos.colored_trees.proxies.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static ColoredTrees instance;

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info("PreInit");
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("Init");
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
