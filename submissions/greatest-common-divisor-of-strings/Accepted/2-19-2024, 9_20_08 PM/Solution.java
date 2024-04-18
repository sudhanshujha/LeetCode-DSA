// https://leetcode.com/problems/greatest-common-divisor-of-strings

import java.util.*;

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // Check if str1 equals str2
        if (str1.equals(str2)) {
            return str1;
        }

        // Check if either string is empty
        if (str1.isEmpty() || str2.isEmpty()) {
            return "";
        }

        // Ensure str2 is longer than str1
        if (str1.length() > str2.length()) {
            return gcdOfStrings(str2, str1);
        }

        // Check if str2 starts with str1
        if (str2.startsWith(str1)) {
            return gcdOfStrings(str1, str2.substring(str1.length()));
        }

        return "";
    }
}
