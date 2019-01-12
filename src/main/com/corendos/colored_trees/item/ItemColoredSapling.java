package com.corendos.colored_trees.item;

import com.corendos.colored_trees.block.BlockColoredSapling;
import com.corendos.colored_trees.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemColored;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ItemColoredSapling extends ItemColored {
    public ItemColoredSapling() {
        super(ModBlocks.block_colored_sapling, true);
        this.setRegistryName(BlockColoredSapling.BLOCK_NAME);
        this.setCreativeTab(CreativeTabs.DECORATIONS);

        String[] names = new String[EnumDyeColor.values().length];

        for (int i = 0;i < names.length;i++) {
            names[i] = EnumDyeColor.byMetadata(i).getName();
        }
        this.setSubtypeNames(names);
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (tab == CreativeTabs.DECORATIONS) {
            for (EnumDyeColor enumDyeColor : EnumDyeColor.values()) {
                items.add(new ItemStack(this, 1, enumDyeColor.getMetadata()));
            }
        }
    }

    @Nullable
    @Override
    public Entity createEntity(World world, Entity location, ItemStack itemstack) {
        EntityItem entityItem = new EntityItem(world, location.posX, location.posY, location.posZ, itemstack);
        entityItem.motionX = location.motionX;
        entityItem.motionY = location.motionY;
        entityItem.motionZ = location.motionZ;

        return entityItem;
    }
}
