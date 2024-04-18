// https://leetcode.com/problems/letter-combinations-of-a-phone-number

import java.util.*;

class Solution {
    public List<String> letterCombinations(String d) {
        List<String> res = new ArrayList<>();
        if (d == null || d.length() == 0) {
            return res;
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
        helper(res, d, 0, new StringBuilder(), map);
        return res;
    }
    
    private void helper(List<String> res, String d, int i, StringBuilder curr, Map<Character, String> map) {
        // res = result, i = index, curr = currrent, d=digits string
        if (i == d.length()) {
            res.add(curr.toString());
            return;
        }
        char digit = d.charAt(i);
        String letters = map.get(digit);
        for (char letter : letters.toCharArray()) {
            curr.append(letter);
            helper(res, d, i + 1, curr, map);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
