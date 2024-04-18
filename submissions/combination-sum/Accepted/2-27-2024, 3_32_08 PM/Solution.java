// https://leetcode.com/problems/combination-sum

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List <List<Integer>> op = new ArrayList<>();
        helper(0, candidates, target, new ArrayList<>(), op);
        return op;
    }

    public static void helper(int index, int[] candidates, int target, List<Integer> ds,List<List<Integer>> op){
        //base
        if(index==candidates.length){
            if(target==0){
                op.add(new ArrayList<>(ds));
            }
            return;
        }
        // included 
        if(candidates[index] <= target){
            ds.add(candidates[index]);
            helper(index, candidates, target - candidates[index], ds, op);
            ds.remove(ds.size() - 1);
            // ds.clear();  Won't this will clear the op me add hua wala pehla ds also as java works by reference
        }
        helper(index+1, candidates, target, ds, op);
    }
}
