// https://leetcode.com/problems/min-cost-climbing-stairs

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 0) return 0;
        if (n == 1) return cost[0];
        
        int prev1 = cost[0]; // Cost to reach the first staircase
        int prev2 = cost[1]; // Cost to reach the second staircase
        
        for (int i = 2; i < n; i++) {
            int currentCost = cost[i] + Math.min(prev1, prev2);
            prev1 = prev2;
            prev2 = currentCost;
        }
        
        return Math.min(prev1, prev2); // Minimum cost to reach the top
    }
}
