package com.corendos.example.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class NewBlock extends Block {
    private static final String BLOCK_NAME = "new_block";
    private static final PropertyDirection FACING =
            PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    private Item itemBlock;

    public NewBlock() {
        super(Material.ROCK);
        this.setCreativeTab(CreativeTabs.DECORATIONS)
                .setUnlocalizedName(BLOCK_NAME)
                .setRegistryName(BLOCK_NAME)
                .setHardness(1.2f);
        itemBlock = new ItemBlock(this);
        itemBlock.setRegistryName(this.getRegistryName());
        this.setDefaultState(this.getBlockState().getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, FACING);
    }

    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        this.setDefaultFacing(worldIn, pos, state);
    }

    private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            IBlockState northBlockState = worldIn.getBlockState(pos.north());
            IBlockState southBlockState = worldIn.getBlockState(pos.south());
            IBlockState westBlockState = worldIn.getBlockState(pos.west());
            IBlockState eastBlockState = worldIn.getBlockState(pos.east());
            EnumFacing enumFacing = state.getValue(FACING);

            if (enumFacing == EnumFacing.NORTH && northBlockState.isFullBlock() && !southBlockState.isFullBlock())
            {
                enumFacing = EnumFacing.SOUTH;
            }
            else if (enumFacing == EnumFacing.SOUTH && southBlockState.isFullBlock() && !northBlockState.isFullBlock())
            {
                enumFacing = EnumFacing.NORTH;
            }
            else if (enumFacing == EnumFacing.WEST && westBlockState.isFullBlock() && !eastBlockState.isFullBlock())
            {
                enumFacing = EnumFacing.EAST;
            }
            else if (enumFacing == EnumFacing.EAST && eastBlockState.isFullBlock() && !westBlockState.isFullBlock())
            {
                enumFacing = EnumFacing.WEST;
            }

            worldIn.setBlockState(pos, state.withProperty(FACING, enumFacing), 2);
        }
    }

    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
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

    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing facing = EnumFacing.getFront(meta);
        if (facing.getAxis() == EnumFacing.Axis.Y) {
            facing = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty(FACING, facing);
    }

    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(FACING).getIndex();
    }
}
