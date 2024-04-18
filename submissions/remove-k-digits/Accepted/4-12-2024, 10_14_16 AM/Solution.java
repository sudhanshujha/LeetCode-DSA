// https://leetcode.com/problems/remove-k-digits

class Solution {
    public String removeKdigits(String num, int k) {
        // Monotonic stack approach
        // If the upcoming digit is smaller than the previous one, remove the previous one
        int n = num.length();
        if (n == 0 || n <= k) return "0"; // Edge cases

        StringBuilder stack = new StringBuilder();
        for (char digit : num.toCharArray()) {
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > digit) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(digit);
        }

        // If there are still remaining digits to remove, remove them from the end
        while (k > 0 && stack.length() > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        // Remove leading zeros
        while (stack.length() > 0 && stack.charAt(0) == '0') {
            stack.deleteCharAt(0);
        }

        return stack.length() == 0 ? "0" : stack.toString();
    }
}
