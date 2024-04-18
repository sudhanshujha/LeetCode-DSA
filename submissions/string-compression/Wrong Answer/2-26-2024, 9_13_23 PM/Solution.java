// https://leetcode.com/problems/string-compression

import java.util.HashMap;

class Solution {
    public int compress(char[] chars) {
        if(chars.length == 1)
            return 1;
        
        // Create a HashMap to store count of each unique characters
        HashMap<Character, Integer> charCount = new HashMap<>();
        
        // Count the occurrence of each character in the array
        for(char c : chars) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // Update the chars array with characters and their counts
        int index = 0;
        for(char c : charCount.keySet()) {
            chars[index++] = c;
            int count = charCount.get(c);
            if(count > 1) {
                for(char digit : Integer.toString(count).toCharArray()) {
                    chars[index++] = digit;
                }
            }
        }
        
        // Return the new size of the array
        return index;
    }
}
