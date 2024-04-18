// https://leetcode.com/problems/missing-number

class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum ^= (i ^ nums[i]);
        }
        return sum ^ n;
    }
}
