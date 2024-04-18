// https://leetcode.com/problems/valid-palindrome

// Character.isLetterOrDigit(s.charAt(i))

class Solution {
    public boolean isPalindrome(String s) {
        // 2 pointers
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue; // Skip non-alphanumeric characters
            }
            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue; // Skip non-alphanumeric characters
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false; // Characters at i and j are not equal
            }
            i++;
            j--;
        }
        return true;
    }
}