// https://leetcode.com/problems/successful-pairs-of-spells-and-potions

import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions); // Sort the potions array
        int n = spells.length;
        
        for (int i = 0; i < n; i++) {
            int target = (int) Math.ceil((double) success / spells[i]); // Round up to ensure we get at least the required strength
            
            int left = 0;
            int right = potions.length - 1;
            int count = 0; // Initialize count for the current spell
            
            // Binary search to find the number of successful potions for the current spell
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (potions[mid] >= target) {
                    count = potions.length - mid; // Number of potions that can form a successful pair
                    right = mid - 1; // Search in the left half for more successful potions
                } else {
                    left = mid + 1; // Search in the right half
                }
            }
            spells[i] = count; // Store the count of successful pairs for the current spell
        }
        
        return spells; // Return the array containing the count of successful pairs for each spell
    }
}
