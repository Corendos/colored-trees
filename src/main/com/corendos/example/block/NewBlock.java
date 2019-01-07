package com.corendos.example.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class NewBlock extends Block {
    private static final String BLOCK_NAME = "new_block";

    private Item itemBlock;

    public NewBlock() {
        super(Material.ROCK);
        this.setCreativeTab(CreativeTabs.DECORATIONS)
                .setUnlocalizedName(BLOCK_NAME)
                .setRegistryName(BLOCK_NAME)
                .setHardness(1.2f);
        itemBlock = new ItemBlock(this);
        itemBlock.setRegistryName(this.getRegistryName());
    }

    public Item getItemBlock() {
        return itemBlock;
    }

    public boolean onBlockActivated(World worldIn,
                                    BlockPos pos,
                                    IBlockState state,
                                    EntityPlayer playerIn,
                                    EnumHand hand,
                                    EnumFacing facing,
                                    float hitX, float hitY, float hitZ) {
        System.out.println(playerIn.getName() + " activated the block at" + pos.toString());
        return true;
    }
}
