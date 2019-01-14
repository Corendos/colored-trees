package com.corendos.colored_trees.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemColoredLeaves extends ItemBlock {
    public ItemColoredLeaves(Block block) {
        super(block);
        this.setRegistryName(block.getRegistryName());
        this.setUnlocalizedName(block.getUnlocalizedName());
    }
}
