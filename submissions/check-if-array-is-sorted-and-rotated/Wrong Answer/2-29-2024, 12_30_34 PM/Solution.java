// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated

class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int minIdx = findMinimumIndex(nums);
        
        // If the array is already sorted, or has only one element, it's considered rotated 0 times
        if (minIdx == 0 || n == 1) {
            return true;
        }
        
        // Check if the array is non-decreasing before and after the rotation point
        for (int i = 1; i < n; i++) {
            int prev = nums[(minIdx + i - 1) % n];
            int curr = nums[(minIdx + i) % n];
            if (prev > curr) {
                return false;
            }
        }
        
        return true;
    }
    
    private int findMinimumIndex(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        // Binary search to find the minimum element (rotation point)
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else { // If nums[mid] == nums[right], decrement right
                right--;
            }
        }
        
        return left;
    }
}
