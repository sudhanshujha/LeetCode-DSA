// https://leetcode.com/problems/maximum-subarray

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = 0, currSum = 0;
        int n = nums.length;
        for (int i : nums){
            currSum += i;
            if(currSum > maxSum) maxSum = currSum;
        } 
        return maxSum;    
    }
}

// [-2,1,-3,4,-1,2,1,-5,4]

// -2
// -2 < -2+1 : 1
// 1 > 1-3 : 1 when faced something that coudn't change currSum = 0, maxSum =
// -3 < 4 : 4
// 4 > 4-1: 4 currSum = 3



