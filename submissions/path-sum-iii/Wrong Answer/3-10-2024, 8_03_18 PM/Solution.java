// https://leetcode.com/problems/path-sum-iii

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        
        return dfs(root, targetSum) + 
        pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }
    
    private int dfs(TreeNode node, int targetSum) {
        if (node == null) {
            return 0;
        }
        
        int count = 0;
        if (node.val == targetSum) {
            count++;
        }
        
        // Recursively explore paths in the left and right subtrees
        count += dfs(node.left, targetSum - node.val);
        count += dfs(node.right, targetSum - node.val);
        
        return count;
    }
}
