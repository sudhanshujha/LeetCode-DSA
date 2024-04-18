// https://leetcode.com/problems/first-missing-positive

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // Step 1: Mark all non-positive integers and integers greater than n as irrelevant
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1; // Marking them as irrelevant
            }
        }
        
        // Step 2: Mark indices corresponding to present positive integers
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]); // Marking the index as present
            }
        }
        
        // Step 3: The first positive index (+1) that is not marked is the answer
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        
        // Step 4: If all indices are marked, then the answer is n + 1
        return n + 1;
    }
}
