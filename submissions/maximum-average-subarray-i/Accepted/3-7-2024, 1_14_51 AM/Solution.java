// https://leetcode.com/problems/maximum-average-subarray-i

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        if (k > n) return 0;
        if (k == n) return (double) Arrays.stream(nums).sum() / k;

        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        } 
        
        double maxSum = sum;
        int i = 0, j = k - 1;
        while (j < n - 1) {
            j++;
            sum += nums[j] - nums[i];
            maxSum = Math.max(maxSum, sum);
            i++; // Increment i separately
        }
        
        return maxSum / k;
    }
}
