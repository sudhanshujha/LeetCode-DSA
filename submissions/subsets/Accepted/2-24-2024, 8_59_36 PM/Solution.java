// https://leetcode.com/problems/subsets

import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        backtrack(nums, 0, currentSubset, result);
        return result;
    }
    
    private void backtrack(int[] nums, int index, List<Integer> currentSubset, List<List<Integer>> result) {
        // Add the current subset to the result
        result.add(new ArrayList<>(currentSubset));
        
        // Generate subsets by considering elements starting from the given index
        for (int i = index; i < nums.length; i++) {
            // Include the current element in the subset
            currentSubset.add(nums[i]);
            
            // Recursively generate subsets with the current element included
            backtrack(nums, i + 1, currentSubset, result);
            
            // Exclude the current element from the subset (backtrack)
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}
