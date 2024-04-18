// https://leetcode.com/problems/delete-node-in-a-bst

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, key);
    }
    
    private TreeNode delete(TreeNode root, int key) {
        if (root == null) return null; // Base case
        
        // If key is found
        if (root.val == key) {
            // Case 1: If the node to be deleted has no children
            if (root.left == null && root.right == null) {
                return null; // Simply delete the node
            }
            // Case 2: If the node to be deleted has only one child
            else if (root.left == null) {
                return root.right; // Replace the node with its right child
            } else if (root.right == null) {
                return root.left; // Replace the node with its left child
            }
            // Case 3: If the node to be deleted has both left and right children
            else {
                // Find the inorder successor (smallest node in the right subtree)
                TreeNode successor = findMin(root.right);
                // Replace the node's value with the inorder successor
                root.val = successor.val;
                // Recursively delete the inorder successor node from the right subtree
                root.right = delete(root.right, successor.val);
            }
        }
        // If key is less than the current node's value, go left
        else if (key < root.val) {
            root.left = delete(root.left, key);
        }
        // If key is greater than the current node's value, go right
        else {
            root.right = delete(root.right, key);
        }
        
        return root;
    }
    
    // Helper function to find the minimum node in a subtree
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
