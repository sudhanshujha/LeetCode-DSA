// https://leetcode.com/problems/unique-paths

// space optimisation
class Solution {
    public int uniquePaths(int m, int n) {
        // Initialize the DP array with 1, as there is only one way to reach any cell in the first row
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        // Iterate over each row starting from the second row
        for (int i = 1; i < m; i++) {
            // Iterate over each column starting from the second column
            for (int j = 1; j < n; j++) {
                // The number of paths to reach the current cell is the sum of the paths from above and from the left
                dp[j] += dp[j - 1];
            }
        }
        
        // The value at dp[n - 1] represents the number of unique paths to reach the bottom-right corner of the grid
        return dp[n - 1];
    }
}
