// https://leetcode.com/problems/reverse-words-in-a-string

class Solution {
    public String reverseWords(String s) {
        // Remove all leading or trailing spaces
        s = s.trim();

        // Split the string into words
        String[] words = s.split("\\s+");

        // Initialize StringBuilder array to store reversed words
        StringBuilder[] reversedWords = new StringBuilder[words.length];

        // Reverse each word and store it in reversedWords array
        for (int i = 0; i < words.length; i++) {
            reversedWords[i] = new StringBuilder(words[i]).reverse();
        }

        // Join the reversed words into a single string
        StringBuilder result = new StringBuilder();
        for (StringBuilder word : reversedWords) {
            result.append(word).append(" ");
        }

        // Remove the trailing space and convert StringBuilder to String
        return result.toString().trim();
    }
}
