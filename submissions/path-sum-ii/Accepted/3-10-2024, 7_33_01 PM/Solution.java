// https://leetcode.com/problems/path-sum-ii

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> SumArray = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        post(root, targetSum, SumArray, list);
        return SumArray;
    }
    public static void post(TreeNode root, int targetSum, List<List<Integer>> SumArray, List<Integer> list) {
        if(root == null){
            return;
        }
        // if(root.val <= targetSum){
            list.add(root.val);
            targetSum = targetSum - root.val;
        // else return;

        // If leaf node and targetSum is 0, add current list to SumArray
        if(targetSum == 0 && root.left == null && root.right == null)
            SumArray.add(new ArrayList<>(list));
            
        // Recursively search left and right subtrees
        post(root.left, targetSum, SumArray, list);
        post(root.right, targetSum, SumArray, list);

        // Backtrack: Remove the last element from the list
        list.remove(list.size()-1);
    }
}