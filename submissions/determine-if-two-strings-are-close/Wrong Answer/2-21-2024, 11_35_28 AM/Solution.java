// https://leetcode.com/problems/determine-if-two-strings-are-close

import java.util.*;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        // Create two hashmaps to store the frequency of characters in word1 and word2
        Map<Character, Integer> word1Map = new HashMap<>();
        Map<Character, Integer> word2Map = new HashMap<>();

        // Count the frequency of characters in word1
        for (char c : word1.toCharArray()) {
            word1Map.put(c, word1Map.getOrDefault(c, 0) + 1);
        }

        // Count the frequency of characters in word2
        for (char c : word2.toCharArray()) {
            word2Map.put(c, word2Map.getOrDefault(c, 0) + 1);
        }

        // Check if the lengths of the two words are the same
        if (word1.length() != word2.length()) {
            return false;
        }

        // Check if the sets of characters in both words are the same
        // If not, return false
        if (!word1Map.keySet().equals(word2Map.keySet())) {
            return false;
        }

        // Check if the sets of frequencies of characters in both words are the same
        // If not, return false
        if (!new HashSet<>(word1Map.values()).equals(new HashSet<>(word2Map.values()))) {
            return false;
        }

        // If all conditions are satisfied, return true
        return true;
    }
}
