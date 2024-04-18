// https://leetcode.com/problems/binary-tree-postorder-traversal

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
    List<Integer> arr = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {        
        if (root == null)
            return Collections.emptyList(); // as return type is list
    
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        arr.add(root.val);
        
        return arr;
    }
}
