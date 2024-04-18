// https://leetcode.com/problems/valid-palindrome

class Solution {
    public boolean isPalindrome(String s) {
        return s.replaceAll("[^a-zA-Z0-9]", "").equalsIgnoreCase(new StringBuilder(s.replaceAll("[^a-zA-Z0-9]", "")).reverse().toString());
    }
}
