// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left, right;
        left = lowestCommonAncestor(root.left, p, q);
        right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : (right == null ? left : root);
    }
}
