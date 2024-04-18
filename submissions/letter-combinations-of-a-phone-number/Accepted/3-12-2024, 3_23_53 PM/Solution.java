// https://leetcode.com/problems/letter-combinations-of-a-phone-number

import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(result, digits, 0, new StringBuilder(), map);
        return result;
    }
    
    private void backtrack(List<String> result, String digits, int index, StringBuilder current, Map<Character, String> map) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = map.get(digit);
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(result, digits, index + 1, current, map);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
