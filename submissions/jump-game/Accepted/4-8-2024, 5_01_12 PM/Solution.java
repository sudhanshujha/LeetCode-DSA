// https://leetcode.com/problems/jump-game

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        // Create a DP array to store whether it's possible to reach each index
        boolean[] dp = new boolean[n];
        // Base case: it's always possible to reach the last index
        dp[n - 1] = true;
        
        // Traverse the array from right to left
        for (int i = n - 2; i >= 0; i--) {
            // Calculate the maximum jump from index i
            int maxJump = Math.min(i + nums[i], n - 1);
            // Check if it's possible to reach any of the indices within the maximum jump range
            for (int j = i + 1; j <= maxJump; j++) {
                // If it's possible to reach index j and from there reach the end, mark index i as reachable
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        // If it's possible to reach index 0, return true; otherwise, return false
        return dp[0];
    }
}
