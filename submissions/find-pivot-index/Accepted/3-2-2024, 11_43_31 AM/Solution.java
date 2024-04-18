// https://leetcode.com/problems/find-pivot-index

class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        // left prefix
        int[] lp = new int[n];
        lp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            lp[i] = lp[i - 1] + nums[i];
        }
        // right prefix
        int[] rp = new int[n];
        rp[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) { // Corrected loop condition
            rp[i] = rp[i + 1] + nums[i]; // Corrected index access
        }
        for (int i = 0; i < n; i++) {
            if (lp[i] == rp[i]) {
                return i; // Corrected to return the index directly
            }
        }
        return -1;
    }
}
