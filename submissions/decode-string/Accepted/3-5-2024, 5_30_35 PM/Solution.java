// https://leetcode.com/problems/decode-string

class Solution {
    public String decodeString(String s) {
        Stack<Object> stack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                count = count * 10 + (ch - '0');
            } else if (ch == '[') {
                stack.push(currentString);
                stack.push(count);
                currentString = new StringBuilder();
                count = 0;
            } else if (ch == ']') {
                int repeatCount = (int) stack.pop();
                StringBuilder decodedString = (StringBuilder) stack.pop();
                for (int i = 0; i < repeatCount; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }
        
        return currentString.toString();
    }
}
