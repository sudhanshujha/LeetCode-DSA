// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0, right = n - 1; 
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                // Found the pair
                return new int[]{left+1, right+1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        // If no pair found
        return new int[0];
    }
}