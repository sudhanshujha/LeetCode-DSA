// https://leetcode.com/problems/removing-stars-from-a-string

class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        
        // Iterate over the string
        for (char c : s.toCharArray()) {
            // Check if the current character is not '*'
            if (c != '*') {
                // Append non-'*' characters to StringBuilder
                sb.append(c);
            } else {
                // If '*' is encountered, delete the last appended character
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        
        return sb.toString();
    }
}