// https://leetcode.com/problems/letter-combinations-of-a-phone-number

import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        
        String[] mappings = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        
        for (char digit : digits.toCharArray()) {
            int size = result.size();
            String letters = mappings[digit - '2'];
            while (size-- > 0) {
                String prefix = result.remove(0);
                for (char letter : letters.toCharArray()) {
                    result.add(prefix + letter);
                }
            }
        }
        
        return result;
    }
}
