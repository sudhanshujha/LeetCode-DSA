// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element

class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0; // Edge case
        int[] pre = new int[n];
        int[] suff = new int[n];
        
        boolean containsZero = Arrays.stream(nums).anyMatch(x -> x == 0);
        if(!containsZero) 
            return n-1;

        int count = 0;
        for (int i = 0; i < n; i++) 
        {
            if (nums[i] == 1) 
            {
                count+=1;
                pre[i] = count;
            } 
            else 
            {   
                count = 0;
                pre[i] = 0;
            }
        } 
        
        count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == 1) {
                count++;
                suff[i] = count;
            } else {
                count = 0;
                suff[i] = 0;
            }
        } 
        
        int max = 0;
        int temp;
        for (int i = 0; i <n; i++) {
            if(i==0 && nums[i]==0) temp = suff[i+1];
            else if(i==n-1 && nums[i]==0) temp = pre[i-1];
            else if(nums[i]==0){
                temp = pre[i-1] + suff[i + 1];
                max = Math.max(temp, max);
            }
        }  
        
        return max;
    }
}