// https://leetcode.com/problems/subsets-ii

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> op = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(nums); // Sorting the input array to handle duplicates
        helper(0, nums, ds, op);
        return op;
    }
    // i for index
     public static void helper(int index, int[] arr, List<Integer> ds, List<List<Integer>> op){
        if(index==arr.length){
            op.add(new ArrayList<>(ds));    // // Add current subset to the result
            // cal by reference precaution
            return;
        }
        ds.add(arr[index]); // // Include the current element
        helper(index+1, arr, ds, op);   // // Recur with the next index
        ds.remove(ds.size() - 1);
        // excluding the element is done by removing the last added element in rec decision tree branch

        // Skip duplicates by checking if the current element is equal to the previous one
        while(index + 1 < arr.length && arr[index] == arr[index + 1]) {
            index++; // Move to the next different element
        }

        helper(index+1, arr, ds, op);
        
    }
}