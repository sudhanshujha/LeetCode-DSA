// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element

class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int maxOnes = 0;
        int left = 0, right = 0;
        int zeroCount = 0;

        while (right < n) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxOnes = Math.max(maxOnes, right - left);
            right++;
        }

        return maxOnes;
    }
}