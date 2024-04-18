// https://leetcode.com/problems/binary-search

class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }
    
    private int search(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1; // Base case: target not found
        }
        
        int mid = left + (right - left) / 2;
        
        if (nums[mid] == target) {
            return mid; // Base case: target found
        } else if (nums[mid] < target) {
            return search(nums, target, mid + 1, right); // Search right half
        } else {
            return search(nums, target, left, mid - 1); // Search left half
        }
    }
}
