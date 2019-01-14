package com.corendos.colored_trees.init;

import com.corendos.colored_trees.item.ItemColoredLeaves;
import com.corendos.colored_trees.item.ItemColoredSapling;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final ItemColoredSapling item_colored_sapling;
    public static final List<ItemColoredLeaves> items_colored_leaves;

    static {
        item_colored_sapling = new ItemColoredSapling();
        items_colored_leaves = new ArrayList<>(16);
    }
}
