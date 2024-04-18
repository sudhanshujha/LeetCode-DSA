// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element

class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int maxOnes = 0;
        int removedZero = 0;
        
        while (right < nums.length) {
            if (nums[right] == 0) {
                removedZero++;
            }
            
            while (removedZero > 1) {
                if (nums[left] == 0) {
                    removedZero--;
                }
                left++;
            }
            
            maxOnes = Math.max(maxOnes, right - left);
            right++;
        }
        
        return maxOnes;
    }
}
