// https://leetcode.com/problems/unique-number-of-occurrences

import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // Map to count occurrences of each element
        Map<Integer, Integer> countMap = new HashMap<>();

        // Count occurrences of each element
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Map to count occurrences of counts
        Map<Integer, Integer> occurrenceCount = new HashMap<>();

        // Count occurrences of counts
        for (int count : countMap.values()) {
            occurrenceCount.put(count, occurrenceCount.getOrDefault(count, 0) + 1);
        }

        // Check if any count occurs more than once
        for (int count : occurrenceCount.values()) {
            if (count > 1) {
                return false;
            }
        }

        return true;
    }
}
