// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree

class Solution {
    int maxLen = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        dfs(root.left, true, 1);
        dfs(root.right, false, 1);
        return maxLen;
    }

    private void dfs(TreeNode node, boolean isLeft, int len) {
        if (node == null) {
            maxLen = Math.max(maxLen, len - 1);
            return;
        }

        if (isLeft) {
            dfs(node.right, false, len + 1);
            dfs(node.left, true, 1);
        } else {
            dfs(node.left, true, len + 1);
            dfs(node.right, false, 1);
        }
    }
}
