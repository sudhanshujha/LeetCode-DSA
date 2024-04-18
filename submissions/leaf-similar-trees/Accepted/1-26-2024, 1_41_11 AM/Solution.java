// https://leetcode.com/problems/leaf-similar-trees

public class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        helper(list1, root1);
        helper(list2, root2);

        return list1.equals(list2);
    }
    private void helper(List<Integer>list, TreeNode root)
    {
        if(root == null)
            return;
        if(root.left == null && root.right==null)
        {
            list.add(root.val);
            return;
        }
        else
        {
            helper(list, root.left);
            helper(list, root.right);
        }
    }
    // public Integer[] inOrder(TreeNode node) {
    //     List<Integer> arr = new ArrayList<>();
    //     if (node == null)
    //         return arr.toArray(new Integer[0]); // Convert ArrayList to Integer[] using toArray
    //     if ((node.left == null) && (node.right == null)) {
    //         arr.add(node.val);
    //     }
    //     arr.addAll(Arrays.asList(inOrder(node.left)));
    //     arr.addAll(Arrays.asList(inOrder(node.right)));
    //     return arr.toArray(new Integer[0]); // Convert ArrayList to Integer[] using toArray
    // }
    }