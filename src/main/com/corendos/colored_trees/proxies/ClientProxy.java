package com.corendos.colored_trees.proxies;

import com.corendos.colored_trees.ColoredTrees;
import com.corendos.colored_trees.block.BlockColoredLeaves;
import com.corendos.colored_trees.block.BlockColoredSapling;
import com.corendos.colored_trees.init.ModBlocks;
import com.corendos.colored_trees.init.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ColoredTrees.logger.info("Registering Models");

        Item item = ModItems.item_colored_sapling;
        NonNullList<ItemStack> subItemList = NonNullList.create();
        item.getSubItems(CreativeTabs.DECORATIONS, subItemList);
        for (ItemStack itemStack : subItemList) {
            ResourceLocation rl = new ResourceLocation(
                    ColoredTrees.MODID,
                    EnumDyeColor.byMetadata(itemStack.getMetadata()).getName() + "_" + BlockColoredSapling.BLOCK_NAME);
            ModelResourceLocation subItemModel = new ModelResourceLocation(rl, null);
            ModelLoader.setCustomModelResourceLocation(item, itemStack.getMetadata(), subItemModel);
        }

        for (int i = 0;i < 16;++i) {
            ModelResourceLocation modelResourceLocation = new ModelResourceLocation(
                    ModItems.items_colored_leaves.get(i).getRegistryName(),
                    null);
            ModelLoader.setCustomModelResourceLocation(ModItems.items_colored_leaves.get(i), 0, modelResourceLocation);
        }

    }
}
