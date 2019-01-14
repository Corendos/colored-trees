package com.corendos.colored_trees.init;

import com.corendos.colored_trees.block.BlockColoredLeaves;
import com.corendos.colored_trees.block.BlockColoredSapling;
import jdk.nashorn.internal.ir.Block;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final BlockColoredSapling block_colored_sapling;
    public static final List<BlockColoredLeaves> blocks_colored_leaves;
    /*public static final BlockColoredLeaves block_orange_colored_leaves;
    public static final BlockColoredLeaves block_magenta_colored_leaves;
    public static final BlockColoredLeaves block_light_blue_colored_leaves;
    public static final BlockColoredLeaves block_yellow_colored_leaves;
    public static final BlockColoredLeaves block_lime_colored_leaves;
    public static final BlockColoredLeaves block_pink_colored_leaves;
    public static final BlockColoredLeaves block_gray_colored_leaves;
    public static final BlockColoredLeaves block_silver_colored_leaves;
    public static final BlockColoredLeaves block_cyan_colored_leaves;
    public static final BlockColoredLeaves block_purple_colored_leaves;
    public static final BlockColoredLeaves block_blue_colored_leaves;
    public static final BlockColoredLeaves block_brown_colored_leaves;
    public static final BlockColoredLeaves block_green_colored_leaves;
    public static final BlockColoredLeaves block_red_colored_leaves;
    public static final BlockColoredLeaves block_black_colored_leaves;*/

    static {
        block_colored_sapling = new BlockColoredSapling();
        blocks_colored_leaves = new ArrayList<>(16);
        /*block_orange_colored_leaves = new BlockColoredLeaves(1);
        block_magenta_colored_leaves = new BlockColoredLeaves(2);
        block_light_blue_colored_leaves = new BlockColoredLeaves(3);
        block_yellow_colored_leaves = new BlockColoredLeaves(4);
        block_lime_colored_leaves = new BlockColoredLeaves(5);
        block_pink_colored_leaves = new BlockColoredLeaves(6);
        block_gray_colored_leaves = new BlockColoredLeaves(7);
        block_silver_colored_leaves = new BlockColoredLeaves(8);
        block_cyan_colored_leaves = new BlockColoredLeaves(9);
        block_purple_colored_leaves = new BlockColoredLeaves(10);
        block_blue_colored_leaves = new BlockColoredLeaves(11);
        block_brown_colored_leaves = new BlockColoredLeaves(12);
        block_green_colored_leaves = new BlockColoredLeaves(13);
        block_red_colored_leaves = new BlockColoredLeaves(14);
        block_black_colored_leaves = new BlockColoredLeaves(15);*/
    }
}
