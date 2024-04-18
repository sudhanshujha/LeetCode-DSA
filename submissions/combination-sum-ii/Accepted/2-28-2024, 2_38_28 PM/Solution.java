// https://leetcode.com/problems/combination-sum-ii

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // Sort the candidates to handle duplicates and enable pruning
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        combinationSumHelper(candidates, target, 0, combination, result);
        return result;
    }

    private void combinationSumHelper(int[] candidates, int target, int startIndex, List<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = startIndex; i < candidates.length && candidates[i] <= target; i++) {
            if (i == startIndex || candidates[i] != candidates[i - 1]) { // Skip duplicates
                combination.add(candidates[i]);
                combinationSumHelper(candidates, target - candidates[i], i + 1, combination, result); // Use i + 1 to avoid reuse of same element
                combination.remove(combination.size() - 1); // Backtrack
            }
        }
    }
}
