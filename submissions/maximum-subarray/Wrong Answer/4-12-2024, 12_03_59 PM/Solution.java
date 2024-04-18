// https://leetcode.com/problems/maximum-subarray

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = 0, currSum = 0;
        int n = nums.length;
        for (int i : nums){
            currSum = Math.max(currSum+i,i);
            if(currSum > maxSum) maxSum = currSum;
        } 
        return maxSum;    
    }
}