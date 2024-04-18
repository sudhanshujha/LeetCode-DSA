// https://leetcode.com/problems/max-number-of-k-sum-pairs

class Solution {
    public int maxOperations(int[] nums, int k) {
        int i=0, j=nums.length-1, count=0, temp;
        while(i<j){
            temp = nums[i]+nums[j];
            if(temp>k)  //move left
                j--;
            else if(temp<k)
                i++;
            else{
                count++;
                i++;
                j--;
            }
        }    
        return count;
    }
}