// https://leetcode.com/problems/unique-number-of-occurrences

import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // Element of array is key, value is count
        Map<Integer, Integer> countMap = new HashMap<>();

        // Count occurrences of each element
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Check if counts are unique using HashSet
        Set<Integer> uniqueCounts = new HashSet<>(countMap.values());
        
        // If the size of uniqueCounts is equal to the size of countMap, all counts are unique
        return uniqueCounts.size() == countMap.size();
    }
}
