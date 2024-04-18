// https://leetcode.com/problems/combination-sum-iii

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<List<Integer>>> dp = new ArrayList<>();
        
        // Initialize the dp array
        for (int i = 0; i <= n; i++) {
            dp.add(new ArrayList<>());  // 
        }
        
        dp.get(0).add(new ArrayList<>()); // Base case: 0 sum is achievable with an empty list
        
        // Iterate over all elements from 1 to 9
        for (int i = 1; i <= 9; i++) {
            // Iterate over all sums from n to i
            for (int j = n; j >= i; j--) {
                // Iterate over all combinations for current sum
                for (List<Integer> combination : dp.get(j - i)) {
                    if (combination.size() < k) { // Ensure combination size is less than k
                        List<Integer> newCombination = new ArrayList<>(combination);
                        newCombination.add(i);
                        dp.get(j).add(newCombination);
                    }
                }
            }
        }
        
        return dp.get(n).stream().filter(list -> list.size() == k).toList();
    }
}
