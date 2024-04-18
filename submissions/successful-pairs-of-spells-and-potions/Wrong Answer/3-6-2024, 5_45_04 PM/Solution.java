// https://leetcode.com/problems/successful-pairs-of-spells-and-potions

import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions); // Sort the potions array
        
        for (int i = 0; i < spells.length; i++) {
            int target = (int) Math.ceil((double) success / spells[i]); 
            // Round up to ensure we get at least the required strength
            
            int left = 0;
            int right = potions.length - 1;
            int count = 0;
            
            // Two Pointers technique to find the number of successful potions
            while (left < potions.length && right >= 0) {
                if ((long) spells[i] * potions[left] >= success) {
                    count += potions.length - left; // All remaining potions form successful pairs
                    break;
                } else if ((long) spells[i] * potions[right] < success) {
                    break; // No potion forms a successful pair
                } else {
                    left++; // Increment left pointer
                    right--; // Decrement right pointer
                }
            }
            
            spells[i] = count;
        }
        
        return spells;
    }
}
