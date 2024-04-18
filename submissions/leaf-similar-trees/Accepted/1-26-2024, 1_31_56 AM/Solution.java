// https://leetcode.com/problems/leaf-similar-trees

public class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> arr1 = new ArrayList<>();
        arr1.addAll(Arrays.asList(inOrder(root1)));
        List<Integer> arr2 = new ArrayList<>();
        arr2.addAll(Arrays.asList(inOrder(root2)));
        return arr1.equals(arr2);
    }

    public Integer[] inOrder(TreeNode node) {
        List<Integer> arr = new ArrayList<>();
        if (node == null)
            return arr.toArray(new Integer[0]); // Convert ArrayList to Integer[] using toArray
        if ((node.left == null) && (node.right == null)) {
            arr.add(node.val);
        }
        arr.addAll(Arrays.asList(inOrder(node.left)));
        arr.addAll(Arrays.asList(inOrder(node.right)));
        return arr.toArray(new Integer[0]); // Convert ArrayList to Integer[] using toArray
    }
    }