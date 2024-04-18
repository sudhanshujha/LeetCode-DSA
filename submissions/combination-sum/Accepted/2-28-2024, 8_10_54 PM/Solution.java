// https://leetcode.com/problems/combination-sum

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 0; i <= target; i++) {
            dp.add(new ArrayList<>()); // Initialize with empty lists
        }

        dp.get(0).add(new ArrayList<>()); // One empty combination for sum 0

        for (int num : candidates) {
            for (int i = num; i <= target; i++) {
                for (List<Integer> combination : dp.get(i - num)) {
                    List<Integer> newCombination = new ArrayList<>(combination);
                    newCombination.add(num);
                    dp.get(i).add(newCombination);
                }
            }
        }

        return dp.get(target); // Final combinations for the target sum
    }
}
