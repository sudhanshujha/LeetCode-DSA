// https://leetcode.com/problems/jump-game

// Dp solution - recursive method by exploring all possibilities but memoization
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        // Base case: it's always possible to reach the last index
        nums[n - 1] = -nums[n - 1];
        
        // Traverse the array from right to left
        for (int i = n - 2; i >= 0; i--) {
            // If nums[i] is already negative, it means it's reachable from a previous index, so continue to the next iteration
            if (nums[i] < 0) continue;
            
            // Calculate the maximum jump from index i
            int maxJump = Math.min(i + nums[i], n - 1);
            // Check if it's possible to reach any of the indices within the maximum jump range
            for (int j = i + 1; j <= maxJump; j++) {
                // If it's possible to reach index j and from there reach the end, mark index i as reachable by making nums[i] negative
                if (nums[j] < 0) {
                    nums[i] = -nums[i];
                    break;
                }
            }
        }
        
        // If nums[0] is negative, it means it's possible to reach the start of the array from the end; otherwise, return false
        return nums[0] < 0;
    }
}
