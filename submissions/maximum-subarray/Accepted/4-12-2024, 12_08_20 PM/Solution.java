// https://leetcode.com/problems/maximum-subarray

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE; // Initialize maxSum to smallest possible value
        int currSum = 0;
        for (int i : nums) {
            currSum = Math.max(currSum + i, i);
            maxSum = Math.max(maxSum, currSum);
        } 
        return maxSum;    
    }
}