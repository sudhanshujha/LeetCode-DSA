// https://leetcode.com/problems/removing-stars-from-a-string

import java.util.Stack;

class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>(); 
        
        // Iterate over the string
        for(int i = 0; i < s.length(); i++) {
            // Check if the current character is not '*'
            if(s.charAt(i) != '*') {
                stack.push(s.charAt(i)); // Push non-'*' characters onto the stack
            } else {
                if(!stack.isEmpty()) {
                    stack.pop(); // If '*' is encountered, pop the top element from the stack
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        // Pop elements from the stack and append them to StringBuilder
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop()); // Use insert(0, ...) to maintain the order
        }
        return sb.toString();
    }
}