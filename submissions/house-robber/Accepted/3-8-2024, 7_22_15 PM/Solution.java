// https://leetcode.com/problems/house-robber

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int a = 0; // dp[i - 2]
        int b = 0; // dp[i - 1]
        int c = 0; // dp[i]

        if (n == 0) return 0;

        a = nums[0];
        if (n == 1) return a;

        b = Math.max(nums[0], nums[1]);
        if (n == 2) return b;

        for (int i = 2; i < n; i++) {
            c = Math.max(a + nums[i], b);
            a = b;
            b = c;
        }

        return c;
    }
}
