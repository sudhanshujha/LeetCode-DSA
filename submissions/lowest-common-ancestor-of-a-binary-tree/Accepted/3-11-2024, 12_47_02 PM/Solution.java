// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathToP = new ArrayList<>();
        List<TreeNode> pathToQ = new ArrayList<>();
        pre(root, p, pathToP);
        pre(root, q, pathToQ);
        int n = Math.min(pathToP.size(), pathToQ.size());
        int i = 0;
        while (i < n) {
            if (pathToP.get(i) != pathToQ.get(i))
                return pathToP.get(i - 1);
            i++;
        }
        return pathToP.get(n - 1);
    }

    public static void pre(TreeNode root, TreeNode node, List<TreeNode> list) {
        if (root == null)
            return;
        list.add(root);
        if (root == node)
            return;
        // search node
        // store path from root to the node in list
        pre(root.left, node, list);
        if (list.get(list.size() - 1) != node) // If the node is not found in the left subtree
            pre(root.right, node, list);

        // don't miss removing last added element during backtracking
        if (list.get(list.size() - 1) != node)
            list.remove(list.size() - 1);
    }
}
