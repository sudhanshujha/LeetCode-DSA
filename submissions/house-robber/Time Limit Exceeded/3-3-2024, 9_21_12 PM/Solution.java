// https://leetcode.com/problems/house-robber

// recursive way
class Solution {
    public int rob(int[] nums) {
        return helper(nums,nums.length-1);    
    }
    public int helper(int[] nums, int index){
        if(index<0) return 0;
        return Math.max(nums[index]+helper(nums, index-2) ,
         helper(nums, index-1));
    }
}