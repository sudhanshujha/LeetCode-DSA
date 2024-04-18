// https://leetcode.com/problems/maximum-average-subarray-i

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        if(k>n) return 0;
        if(k==n && n==1) return nums[0]/k;
        double sum = 0;
        for(int i=0; i<k; i++){
            sum += nums[i];
        } 
        int j=k-1;
        int i=0;
        while(j<n-1)
            {
                j++;
                i++;
                sum = Math.max(sum,sum+nums[j]-nums[i-1]);
            }
        
        return (double)sum/k;       
    }
}