// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree

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

        /*1. At each node, we check if given node is one of -> p or q. If so, we return the current node. */
        if (root == null || root == p || root == q) return root;

        // 2. Then, search LCA in left & right subtrees.
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // return left == null ? right : (right == null ? left : root);
        // 2.1.If both subtrees returns non-null, current node is LCA.
// Otherwise, if only 1 subtree returns a non-null, that subtree's result is the LCA.

        if (left == null) return right;
	    else if (right == null) return left;
	    else return root; 
    }
}