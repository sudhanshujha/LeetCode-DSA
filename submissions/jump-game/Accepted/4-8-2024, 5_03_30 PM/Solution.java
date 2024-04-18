// https://leetcode.com/problems/jump-game

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        
        // Base case: it's always possible to reach the last index
        nums[n - 1] = -1; // Mark the last index as reachable
        
        // Traverse the array from right to left
        for (int i = n - 2; i >= 0; i--) {
            // If the value at index i is non-negative, it means it's reachable
            if (nums[i] >= 0) {
                // Update the indices within the maximum jump range from index i
                for (int j = 1; j <= nums[i]; j++) {
                    // If the target index is within bounds and it's marked as reachable (-1),
                    // mark index i as reachable and break the loop
                    if (i + j < n && nums[i + j] == -1) {
                        nums[i] = -1;
                        break;
                    }
                }
            }
        }
        
        // If index 0 is reachable, return true; otherwise, return false
        return nums[0] == -1;
    }
}
