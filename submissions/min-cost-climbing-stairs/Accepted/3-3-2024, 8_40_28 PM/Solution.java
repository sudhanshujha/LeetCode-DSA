// https://leetcode.com/problems/min-cost-climbing-stairs

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n+1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        if(cost.length == 0)
            return dp[0];
        if(cost.length == 1)
            return dp[1];
        else{
            for(int i=2;i<n;i++){
                dp[i] = cost[i] + Math.min(dp[i-1],dp[i-2]);
            }
            return Math.min(dp[n-1],dp[n-2]);
        }
    }
}