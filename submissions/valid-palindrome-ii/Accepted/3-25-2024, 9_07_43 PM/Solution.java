// https://leetcode.com/problems/valid-palindrome-ii

class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                // Try removing either character at i or j
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
        }
        
        // If the loop completes, the string is a valid palindrome
        return true;
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
