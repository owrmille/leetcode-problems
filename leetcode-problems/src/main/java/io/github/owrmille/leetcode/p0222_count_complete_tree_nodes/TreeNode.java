package io.github.owrmille.leetcode.p0222_count_complete_tree_nodes;

/*
- LeetCode 222: Count Complete Tree Nodes
- Difficulty: easy (medium)
- Topics:
Binary Search
Bit Manipulation
Tree
Binary Tree
- Approach:
count as regular case with recursion on left and right child and base condition: root == null -> 0;
add optimization (check if subtree is perfect: if leftHeight==rightHeight -> if so, 2^(h+1) is number of its nodes)
- Time: O(log^2 n)  Space: O(log n)
*/


//  Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int findLeftHeight(TreeNode root) {
        int h = 0;
        while (root.left != null) {
            h++;
            root = root.left;
        }
        return h;
    }

    public int findRightHeight(TreeNode root) {
        int h = 0;
        while (root.right != null) {
            h++;
            root = root.right;
        }
        return h;
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = findLeftHeight(root);
        int rightHeight = findRightHeight(root);
        if (leftHeight == rightHeight) return ((int)Math.pow(2, leftHeight + 1) - 1);
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
