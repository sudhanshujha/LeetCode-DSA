// https://leetcode.com/problems/binary-tree-level-order-traversal

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderList = new ArrayList<>();

        if (root == null) {
            return levelOrderList; // Return an empty list if the tree is empty
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Queue size indicates the number of nodes at the current level
            List<Integer> eachLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                eachLevel.add(current.val);

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            levelOrderList.add(eachLevel); // Add the current level to the result list
        }

        return levelOrderList;
    }
}
