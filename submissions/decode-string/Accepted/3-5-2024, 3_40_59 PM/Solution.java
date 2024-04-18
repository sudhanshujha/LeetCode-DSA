// https://leetcode.com/problems/decode-string

class Solution {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        StringBuilder currentString = new StringBuilder();
        int count = 0;
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                count = count * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(count);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                count = 0;
            } else if (ch == ']') {
                int repeatCount = countStack.pop();
                StringBuilder decodedString = stringStack.pop();
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
