// https://leetcode.com/problems/reverse-words-in-a-string

class Solution {
    public String reverseWords(String s) {
        // Split the string into words
        String[] words = s.trim().split("\\s+");
        
        // Reverse the order of words
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
}
