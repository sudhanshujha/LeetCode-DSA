// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree

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
    public int maxLevelSum(TreeNode root) {
        if(root == null) return 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0, ans = 0, sum = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int size = q.size();
            int max = 0;
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                max = max + curr.val;
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            level++;
            if(max > sum){
                ans = level;
                sum = max;
            }
        }
        return ans;
    }
}