// https://leetcode.com/problems/subsets

import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(nums, 0, subset, result);
        return result;
    }
    
    private void backtrack(int[] nums, int index, List<Integer> subset, List<List<Integer>> result) {
        // Add the current subset to the result
        result.add(new ArrayList<>(subset));
        
        // Generate subsets by considering elements starting from the given index
        for (int i = index; i < nums.length; i++) {
            // Include the current element in the subset
            subset.add(nums[i]);
            
            // Recursively generate subsets with the current element included
            backtrack(nums, i + 1, subset, result);
            
            // Exclude the current element from the subset (backtrack)
            subset.remove(subset.size() - 1);
        }
    }
}
