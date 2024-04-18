// https://leetcode.com/problems/path-sum-iii

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
    HashMap<Long,Integer> map=new HashMap<>();
    int count;
    public int pathSum(TreeNode root, int targetSum) {
      if(root==null){
        return 0;
      }  
      count=0;
      helper(root,targetSum,0);
      return count;
    }
    private void helper(TreeNode root,int t,long cs){
        if(root==null){
            return;
        }
        cs+=root.val;
        if(map.containsKey(cs-t)){
            count+=map.get(cs-t);
        }
        if(t==cs){
            count++;
        }
        map.put(cs,map.getOrDefault(cs,0)+1);
        helper(root.left,t,cs);
        helper(root.right,t,cs);
        map.put(cs,map.get(cs)-1);
    }
}