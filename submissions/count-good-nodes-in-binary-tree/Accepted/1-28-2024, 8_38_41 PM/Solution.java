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
        int max = Integer.MIN_VALUE;
        return dfs(root,max);
    }

    public int dfs(TreeNode root, int max){
           if (root == null)
            return 0;

        int count = 0;
        // Pre-order
        if (root.val >= max) {
            max = root.val;
            count++;
        }
     
        count += dfs(root.left,max);
        count += dfs(root.right,max);
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