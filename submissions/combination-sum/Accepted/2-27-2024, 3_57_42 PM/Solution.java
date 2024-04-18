// https://leetcode.com/problems/combination-sum

//  https://leetcode.com/problems/combination-sum/solutions/16502/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List <List<Integer>> op = new ArrayList<>();
        List <Integer> ds = new ArrayList<>();
        helper(0, candidates, target, ds, op);
        return op;
    }

    public static void helper(int index, int[] candidates, int target, List<Integer> ds,List<List<Integer>> op){
        //base
        if(index==candidates.length){
            if(target==0){
                op.add(new ArrayList<>(ds));
                // op.add(ds) any changes made to ds afterwards will reflect in all the lists inside op. 
                // By creating a new ArrayList with new ArrayList<>(ds), you're essentially creating a copy of ds at that moment, 
                // ensuring that further modifications to ds won't affect the elements already added to op.
            }
            return;
        }
        // included 
        if(candidates[index] <= target){
            ds.add(candidates[index]);
            helper(index, candidates, target - candidates[index], ds, op);
            ds.remove(ds.size() - 1);
            // ds.clear() would indeed clear the ds list, but it would affect all the previous states stored in op as Java works with references.
            // undoing the addition made in the current recursive call without affecting previous states stored in op.
        }
        //excluded
        helper(index+1, candidates, target, ds, op);
    }
}
