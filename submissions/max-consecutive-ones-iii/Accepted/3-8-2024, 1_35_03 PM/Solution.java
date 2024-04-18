// https://leetcode.com/problems/max-consecutive-ones-iii

class Solution 
{ 
    public int longestOnes(int[] nums, int k) 
    {
        int i = 0, j = 0, n = nums.length, op = 0;      
        while(j<n)
        { 
                if(nums[j]==0) k--;   
                while(k<0)
                {
                        if(nums[i]==0) k++; 
                        i++; 
                }
                op = Math.max(op, j-i+1);
                j++; 
        } 
        return op;
    }
}