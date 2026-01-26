package io.github.owrmille.leetcode.p0222_count_complete_tree_nodes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void example1() {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3, new TreeNode(6), null)
        );

        assertEquals(6, s.countNodes(root));
    }

    @Test
    void example2() {
        Solution s = new Solution();

        assertEquals(0, s.countNodes(null));
    }

    @Test
    void example3() {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);

        assertEquals(1, s.countNodes(root));
    }

    @Test
    void perfectTreeHeightTwo() {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3, new TreeNode(6), new TreeNode(7))
        );

        assertEquals(7, s.countNodes(root));
    }

    @Test
    void lastLevelPartiallyFilledLeftToRight() {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1,
            new TreeNode(2, new TreeNode(4), null),
            new TreeNode(3, null, null)
        );

        assertEquals(4, s.countNodes(root));
    }
}
