// https://leetcode.com/problems/house-robber

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];  
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        if(n==0)
            return nums[0];
        if(n==1)
            return dp[1];
        for(int i=2;i<n;i++){
            // ensure of not stealing from adj
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[n-1];
    }
}
// dp[0] = 1
// dp[1] = 2 = max(1,2)=max(nums[0],nums[1])
// dp[2] = 1+3 = 4 = max(dp[0]+ nums[2], dp[1])
// dp[3] = 

// dp[i] = max(dp[i-2]+nums[i]),dp[i-1])