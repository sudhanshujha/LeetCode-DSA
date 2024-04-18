// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated

class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone(); // Make a duplicate of nums
        
        // Sort the duplicate array
        Arrays.sort(sorted);
        
        // Find the number by which the array is rotated
        int rotation = 0;
        while (rotation < n && sorted[rotation] != nums[0]) {
            rotation++;
        }
        
        // Check if the array is sorted in ascending order when shifted by rotation
        for (int i = 0; i < n; i++) {
            if (nums[i] != sorted[(i + rotation) % n]) {
                return false;
            }
        }
        
        return true;
    }
}
