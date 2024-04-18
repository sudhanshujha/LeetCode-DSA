// https://leetcode.com/problems/leaf-similar-trees

public class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder leafSequence1 = new StringBuilder();
        StringBuilder leafSequence2 = new StringBuilder();

    helper(leafSequence1, root1);
    helper(leafSequence2, root2);

    return leafSequence1.toString().equals(leafSequence2.toString());
    }
    private void helper(StringBuilder leafSequence, TreeNode root) {
    if (root == null) {
        return;
    }
    if (root.left == null && root.right == null) {
        leafSequence.append(root.val);
        return;
    } else {
        helper(leafSequence, root.left);
        helper(leafSequence, root.right);
    }
}
}