// https://leetcode.com/problems/valid-parentheses

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        // Convert string into char array
        char[] chars = s.toCharArray();
        
        // Iterate through each character in the string
        for (char c : chars) {
            // If the character is an opening bracket, push it onto the stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // If the character is a closing bracket, check if it matches the top of the stack
                if (stack.isEmpty()) {
                    return false; // More closing brackets than opening brackets
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false; // Mismatched brackets
                }
            }
        }
        
        // After iterating through the string, if the stack is empty, all brackets are matched
        return stack.isEmpty();
    }
}
