// https://leetcode.com/problems/jump-game

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxReach = 0;
        
        for (int i = 0; i < n; i++) {
            // If the current index is beyond the maximum reachable index, return false
            if (i > maxReach) {
                return false;
            }
            
            // Update the maximum reachable index if the current index plus its value can reach beyond it
            maxReach = Math.max(maxReach, i + nums[i]);
            
            // If the maximum reachable index exceeds or equals the last index, return true
            if (maxReach >= n - 1) {
                return true;
            }
        }
        
        // If we haven't reached the last index by the end of the loop, return false
        return false;
    }
}
