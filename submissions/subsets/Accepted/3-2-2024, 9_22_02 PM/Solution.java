// https://leetcode.com/problems/subsets

// using bitmasking
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        int n = nums.length;
        
        // Iterate through all possible numbers from 0 to 2^n - 1
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            
            // Iterate through each bit of the current number
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    subset.add(nums[j]); // Include nums[j] in the subset
                }
            }
            subsets.add(subset); // Add the subset to the list of subsets
        }
        return subsets;
    }
}
