// https://leetcode.com/problems/combination-sum

//using dp
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>[] dp = new List[target + 1];
        dp[0] = new ArrayList<>();
        dp[0].add(new ArrayList<>());
          
        for (int c : candidates) {
            for (int i = c; i <= target; i++) {
                if (dp[i - c] != null) {
                    if (dp[i] == null)
                        dp[i] = new ArrayList<>();
                                    
                    for (List<Integer> list : dp[i - c]) {
                        List<Integer> copy = new ArrayList<>(list);
                        copy.add(c);
                        
                        dp[i].add(copy);
                    }
                }
            }            
        } 
        
        return dp[target] == null ? new ArrayList<>() : dp[target];
    }
}
