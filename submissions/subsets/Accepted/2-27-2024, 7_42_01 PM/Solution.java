// https://leetcode.com/problems/subsets

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> op = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        helper(0, nums, ds, op);
        return op;    
    }
    //i stands for index
    public static void helper(int i, int[] arr, List<Integer> ds, List<List<Integer>> op){
        if(i==arr.length){
            op.add(new ArrayList<>(ds));
            // cal by reference precaution
            return;
        }
        ds.add(arr[i]);
        helper(i+1, arr, ds, op);

        ds.remove(ds.size() - 1);
        // excluding the element is done by removing the last element
        helper(i+1, arr, ds, op);
        
    }
}