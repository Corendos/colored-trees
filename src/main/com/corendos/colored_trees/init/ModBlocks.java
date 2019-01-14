package com.corendos.colored_trees.init;

import com.corendos.colored_trees.block.BlockColoredLeaves;
import com.corendos.colored_trees.block.BlockColoredSapling;
import jdk.nashorn.internal.ir.Block;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<BlockColoredSapling> blocks_colored_sapling;
    public static final List<BlockColoredLeaves> blocks_colored_leaves;

    static {
        blocks_colored_sapling = new ArrayList<>(16);
        blocks_colored_leaves = new ArrayList<>(16);
    }
}
