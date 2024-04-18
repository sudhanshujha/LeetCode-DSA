// https://leetcode.com/problems/combination-sum-iii

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> a = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            a.add(i);
        }
        List<List<Integer>> op = new ArrayList<>(); 
        List<Integer> ds = new ArrayList<>();
        helper(0, n, k, a, ds, op);
        return op;
    }

    public static void helper(int i, int target, int k, List<Integer> a, List<Integer> ds, List<List<Integer>> op){
        if (i == a.size() || target <= 0 || k <= 0) {
            if (target == 0 && k == 0) {
                op.add(new ArrayList<>(ds));
            }
            return;
        }

        int temp = a.get(i);
        if (temp <= target) { // Add the condition to prevent unnecessary calls
            // Include the current element
            ds.add(temp);
            helper(i + 1, target - temp, k - 1, a, ds, op);
            ds.remove(ds.size() - 1); // Backtrack
        }
        
        // Exclude the current element
        helper(i + 1, target, k, a, ds, op);
    }
}
