// https://leetcode.com/problems/house-robber

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        
        int prev1 = nums[0]; // Maximum amount that can be robbed up to and including the first house
        int prev2 = Math.max(nums[0], nums[1]); // Maximum amount that can be robbed up to and including the second house
        
        for (int i = 2; i < n; i++) {
            int currentMax = Math.max(prev1 + nums[i], prev2);
            prev1 = prev2;
            prev2 = currentMax;
        }
        
        return prev2; // Maximum amount that can be robbed up to and including the last house
    }
}
