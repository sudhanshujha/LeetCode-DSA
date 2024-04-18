// https://leetcode.com/problems/find-peak-element

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid;

        while (low < high) {
            mid = low + (high - low) / 2;

            // Check if mid is at the beginning or end of the array
            if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid; // Found peak element
            } else if (mid > 0 && nums[mid - 1] > nums[mid]) {
                high = mid - 1; // Peak is on the left side
            } else {
                low = mid + 1; // Peak is on the right side
            }
        }

        return low; // Return low or high (they are equal) as peak element
    }
}
