package com.corendos.colored_trees.block;

import com.corendos.colored_trees.ColoredTrees;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nonnull;
import java.util.List;

public class BlockColoredLeaves extends BlockLeaves {
    public static final String BLOCK_NAME = "colored_leaves";
    private EnumDyeColor color;

    public BlockColoredLeaves(int colorMetadata) {
        this(EnumDyeColor.byMetadata(colorMetadata));
    }

    public BlockColoredLeaves(EnumDyeColor color) {
        super();
        this.setDefaultState(this.blockState.getBaseState()
                .withProperty(CHECK_DECAY, true)
                .withProperty(DECAYABLE, true));
        this.setRegistryName(color.getName() + "_" + BLOCK_NAME);
        this.setUnlocalizedName(ColoredTrees.MODID + "." + BLOCK_NAME +"." + color.getName());
        this.color = color;
    }

    @Nonnull
    @Override
    public BlockPlanks.EnumType getWoodType(int meta) {
        return BlockPlanks.EnumType.OAK;
    }

    @Nonnull
    @Override
    public List<ItemStack> onSheared(@Nonnull ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        return NonNullList.withSize(1, new ItemStack(this, 1, color.getMetadata()));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, CHECK_DECAY, DECAYABLE);
    }

    @Override
    public int damageDropped(IBlockState state) {
        return color.getMetadata();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState()
                .withProperty(CHECK_DECAY, (meta & 1) != 0)
                .withProperty(DECAYABLE, (meta & 2) != 0);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int meta = 0;
        if (state.getValue(CHECK_DECAY)) {
            meta += 1;
        }

        if (state.getValue(DECAYABLE)) {
            meta += 1 << 1;
        }
        return meta;
    }

    @Override
    protected ItemStack getSilkTouchDrop(IBlockState state) {
        return new ItemStack(this, 1, color.getMetadata());
    }

    public EnumDyeColor getColor() {
        return color;
    }
}
