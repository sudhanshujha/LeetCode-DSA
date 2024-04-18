// https://leetcode.com/problems/minimum-window-substring

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        // Step 1: Create a frequency map of characters in string t
        Map<Character, Integer> targetFreqMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetFreqMap.put(c, targetFreqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Initialize variables
        int left = 0, right = 0, minLeft = 0, minLen = Integer.MAX_VALUE;
        int requiredChars = targetFreqMap.size();
        int formedChars = 0;
        Map<Character, Integer> windowFreqMap = new HashMap<>();

        // Step 3: Iterate through string s using two pointers
        while (right < s.length()) {
            char c = s.charAt(right);
            windowFreqMap.put(c, windowFreqMap.getOrDefault(c, 0) + 1);
            if (targetFreqMap.containsKey(c) && windowFreqMap.get(c).intValue() == targetFreqMap.get(c).intValue()) {
                formedChars++;
            }

            // Step 4: Shrink the window
            while (left <= right && formedChars == requiredChars) {
                char leftChar = s.charAt(left);
                int windowLen = right - left + 1;
                if (windowLen < minLen) {
                    minLeft = left;
                    minLen = windowLen;
                }

                windowFreqMap.put(leftChar, windowFreqMap.get(leftChar) - 1);
                if (targetFreqMap.containsKey(leftChar) && windowFreqMap.get(leftChar) < targetFreqMap.get(leftChar)) {
                    formedChars--;
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}