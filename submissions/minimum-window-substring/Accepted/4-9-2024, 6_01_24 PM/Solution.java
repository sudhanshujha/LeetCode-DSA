// https://leetcode.com/problems/minimum-window-substring

import java.util.Arrays;

class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        Arrays.fill(map, 0);
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        
        int counter = t.length();
        int begin = 0, end = 0, d = Integer.MAX_VALUE, head = 0;
        
        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) {
                counter--; // in t
            }
            while (counter == 0) { // valid
                if (end - begin < d) {
                    d = end - (head = begin);
                }
                if (map[s.charAt(begin++)]++ == 0) {
                    counter++; // make it invalid
                }
            }
        }
        
        return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
    }
}
