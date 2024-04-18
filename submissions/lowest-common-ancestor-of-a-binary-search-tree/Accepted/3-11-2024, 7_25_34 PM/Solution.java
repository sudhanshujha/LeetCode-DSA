// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = null, right =null;
        if(p.val < root.val || q.val < root.val)
            left = lowestCommonAncestor(root.left, p, q);
        if(p.val > root.val || q.val > root.val)
            right = lowestCommonAncestor(root.right, p, q);
        if(left!= null && right!= null)
            return root; // Current node is lca
        else if (left != null) 
            return left; // lca found in left subtree
        else 
            return right; // lca found in right subtree 
    }
}