// https://leetcode.com/problems/combination-sum-iii

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        // int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> a = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            a.add(i);
        }
        List<List<Integer>> op = new ArrayList<>(); 
        List<Integer> ds = new ArrayList<>();
        helper(0, n, k, a, ds, op);
        return op;
    }
    // i for index, ds for subset
    public static void helper(int i, int target, int k, List<Integer> a, List<Integer> ds, List<List<Integer>> op){
        if(i == a.size() || target <= 0 || k <= 0){
            if (target == 0 && k == 0) {
                op.add(new ArrayList<>(ds));
            }
            return;
        }

        // Include the current element
        ds.add(a.get(i));
        helper(i + 1, target - a.get(i), k - 1, a, ds, op);
        ds.remove(ds.size() - 1); // Backtrack
        
        // Exclude the current element
        helper(i + 1, target, k, a, ds, op);
    }
}