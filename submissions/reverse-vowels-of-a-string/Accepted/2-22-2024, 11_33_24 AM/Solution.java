// https://leetcode.com/problems/reverse-vowels-of-a-string

class Solution {
    public String reverseVowels(String s) {
        StringBuilder vowels = new StringBuilder();
        for (char c : s.toCharArray()) {
            // Append vowels from string in sequence
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                vowels.append(c);
            }
        }
        vowels.reverse();
        StringBuilder result = new StringBuilder();
        int vowelIndex = 0;
        for (char c : s.toCharArray()) {
            // If the character is a vowel, append the corresponding character from the reversed sequence
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                result.append(vowels.charAt(vowelIndex));
                vowelIndex++;
            } else {
                // If the character is not a vowel, append it as it is
                result.append(c);
            }
        }
        return result.toString();
    }
}
