// https://leetcode.com/problems/merge-strings-alternately

class Solution {
    public String mergeAlternately(String word1, String word2) {
        // StringBuilder to concatenate characters
        StringBuilder result = new StringBuilder();

        // Determine the minimum length between word1 and word2
        int minLength = Math.min(word1.length(), word2.length());

        // Merge strings alternately up to the minimum length
        for (int i = 0; i < minLength; i++) {
            result.append(word1.charAt(i)).append(word2.charAt(i));
        }

        // Add the remaining characters from the longer string
        if (word1.length() <= word2.length()) {
            result.append(word2.substring(minLength));
        } else {
            result.append(word1.substring(minLength));
        }

        return result.toString();
    }
}
