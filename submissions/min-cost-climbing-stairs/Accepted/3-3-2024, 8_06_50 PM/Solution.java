// https://leetcode.com/problems/min-cost-climbing-stairs

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // dp stores the minimum cost to climb to the top starting from the ith staircase.
        int[] dp = new int[n + 1];

        // Base cases: Cost to reach the first and second stairs is the cost of the respective stairs.
        dp[0] = cost[0];
        dp[1] = cost[1];

        // Iterate through the stairs, calculating the minimum cost to reach each staircase.
        for (int i = 2; i < n; i++) {
            // The minimum cost to reach the current staircase is the cost of the current staircase
            // plus the minimum cost of reaching the previous staircase or the one before that.
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        // The minimum cost to reach the top is the minimum cost of reaching the last or second last staircase.
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
