// https://leetcode.com/problems/combination-sum-ii

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> op = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(candidates); // Sort candidates to handle duplicates
        helper(0, target, candidates, ds, op);
        return op;
    }
    
    public static void helper(int i, int target, int[] arr, List<Integer> ds, List<List<Integer>> op) {
        if (i == arr.length) {
            if (target == 0) {
                op.add(new ArrayList<>(ds));
            }
            return;
        }
        
        // Include the current element if it doesn't exceed the target
        if (arr[i] <= target) {
            ds.add(arr[i]);
            helper(i + 1, target - arr[i], arr, ds, op); // Recursive call after including the current element
            ds.remove(ds.size() - 1); // Backtrack: remove the last element to explore other possibilities
        }
        
        // Skip duplicates
        while (i + 1 < arr.length && arr[i] == arr[i + 1]) {
            i++;
        }
        
        // Recursive call without including the current element
        helper(i + 1, target, arr, ds, op);
    }
}
