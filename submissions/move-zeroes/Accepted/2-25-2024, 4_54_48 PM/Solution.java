// https://leetcode.com/problems/move-zeroes

class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i =0,j,k;
        for (j =0;j<n;j++)
        {
            if(nums[j] != 0)
            {
                nums[i] = nums[j];
                i++;
            }
        }
        for(k = i ; k<n ;k++)
        {
            nums[k] = 0;
        }
    }
}