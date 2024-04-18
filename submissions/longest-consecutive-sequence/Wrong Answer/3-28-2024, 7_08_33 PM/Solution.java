// https://leetcode.com/problems/longest-consecutive-sequence

//using hash map
// sliding window with sorting -> works for +ve numbers
class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int max = 1;
        int maxsofar = 1;
        int n = nums.length;
        if(n==0) return 0;
        for(int i=0; i<n-1;i++){
            if(nums[i+1] == nums[i]+1) max++;
            else max = 1;
            maxsofar = Math.max(max,maxsofar);
        }
        return maxsofar;
    }
}