// https://leetcode.com/problems/longest-substring-without-repeating-characters

import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int start = 0; // Start index of the current substring

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            // If the character is already in the set, remove characters from the set until the repeated character is removed
            while (set.contains(c)) {
                set.remove(s.charAt(start));
                start++; // Move the start index forward to exclude the repeated character
            }
            // Add the current character to the set
            set.add(c);
            // Update the maximum length if needed
            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}
