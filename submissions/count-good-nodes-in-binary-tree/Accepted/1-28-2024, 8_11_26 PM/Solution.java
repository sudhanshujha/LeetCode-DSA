// https://leetcode.com/problems/count-good-nodes-in-binary-tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }

        int count = (node.val >= maxSoFar) ? 1 : 0;

        count += dfs(node.left, Math.max(maxSoFar, node.val));
        count += dfs(node.right, Math.max(maxSoFar, node.val));

        return count;
    }
}


// iterate the tree from root node.
// root will always be a good so as there is no number to compare it with, count++
// store root as max
// now, go to left subtree, 
// if child value >= max 
//      update max & count++

// else 
//     move on.
//now, do the same for right subtree 