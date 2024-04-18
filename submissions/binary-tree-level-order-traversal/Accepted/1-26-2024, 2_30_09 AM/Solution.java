// https://leetcode.com/problems/binary-tree-level-order-traversal

// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */

// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> levelOrderList = new ArrayList<>();
//         Queue<Node> queue = new LinkedList<>();

//         while (!queue.isEmpty()) {
//             int level = queue.size();
//             List<Integer> ByLevel = new ArrayList<>();
//             for(int i=0; i<=level;i++){
//                 Node current = queue.poll(); // Remove the front of the queue
//             }      
           
//             if (current.left != null) {
//                 queue.add(current.left);
//                 levelOrderList[lvl].add(current);
//             }

//             if (current.right != null) {
//                 queue.add(current.right);
//                 levelOrderList[lvl].add(current)
//             }
//         }
        
//     }

// }

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> finalAns = new ArrayList<List<Integer>>();
        if(root==null){
            return finalAns;
        }
        q.add(root);
        while(!q.isEmpty()){
            int levels = q.size();
            List<Integer> subLevels = new ArrayList<>();
            for(int i=0;i<levels;i++){
                if(q.peek().left!=null){
                    q.add(q.peek().left);
                }
                if(q.peek().right!=null){
                    q.add(q.peek().right);
                }
                subLevels.add(q.remove().val);
            }
            finalAns.add(subLevels);
        }
        return finalAns;
    }
}