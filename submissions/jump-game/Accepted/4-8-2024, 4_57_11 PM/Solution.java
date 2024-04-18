// https://leetcode.com/problems/jump-game

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int lastReachable = n - 1;
        
        for (int i = n - 2; i >= 0; i--) {
            // Check if the current index (i) plus its value can reach beyond the current last reachable index
            if (i + nums[i] >= lastReachable) {
                // Update the last reachable index
                lastReachable = i;
            }
        }
        
        // If the first index (0) can reach the last reachable index, return true
        return lastReachable == 0;
    }
}
