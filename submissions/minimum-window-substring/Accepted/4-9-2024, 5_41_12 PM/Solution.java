// https://leetcode.com/problems/minimum-window-substring

import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        // Step 1: Create frequency maps for characters in strings s and t
        int[] sFreq = new int[128]; // ASCII character set
        int[] tFreq = new int[128];
        for (char c : t.toCharArray()) {
            tFreq[c]++;
        }

        // Step 2: Initialize variables
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        int left = 0;
        int formed = 0;

        // Step 3: Iterate through string s using two pointers
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            sFreq[c]++;

            // If the current character forms part of the desired window, increment the 'formed' count
            if (tFreq[c] > 0 && sFreq[c] <= tFreq[c]) {
                formed++;
            }

            // Step 4: Shrink the window while all characters in t are present in the current window
            while (formed == t.length()) {
                // Update the minimum window length if necessary
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                // Update frequency map and 'formed' count
                char leftChar = s.charAt(left);
                sFreq[leftChar]--;
                if (tFreq[leftChar] > 0 && sFreq[leftChar] < tFreq[leftChar]) {
                    formed--;
                }
                left++;
            }
        }

        // Step 5: Return the minimum window substring
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}
