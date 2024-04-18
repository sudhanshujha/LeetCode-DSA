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

        // Check if the sets of characters in both words are the same
        if (!word1Map.keySet().equals(word2Map.keySet())) {
            return false;
        }

        // Create two lists to store the frequencies of characters in word1 and word2
        List<Integer> freq1 = new ArrayList<>(word1Map.values());
        List<Integer> freq2 = new ArrayList<>(word2Map.values());

        // Sort the frequency lists
        Collections.sort(freq1);
        Collections.sort(freq2);

        // Check if the frequency lists are equal
        return freq1.equals(freq2);
    }
}
