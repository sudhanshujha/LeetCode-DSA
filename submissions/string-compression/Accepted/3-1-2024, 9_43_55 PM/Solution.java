// https://leetcode.com/problems/string-compression

class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        if (n == 0) return 0;
        
        int writeIndex = 0;
        int anchor = 0;
        
        for (int readIndex = 0; readIndex < n; readIndex++) {
            if (readIndex == n - 1 || chars[readIndex] != chars[readIndex + 1]) {
                chars[writeIndex++] = chars[anchor];
                if (readIndex > anchor) {
                    for (char c : ("" + (readIndex - anchor + 1)).toCharArray()) {
                        chars[writeIndex++] = c;
                    }
                }
                anchor = readIndex + 1;
            }
        }
        
        return writeIndex;
    }
}
// Instead of using a StringBuilder, this approach directly modifies the input char array chars in place.
// It uses two pointers: readIndex to iterate over the characters and writeIndex to track the position where the compressed characters should be written back.
// anchor is used to mark the beginning of each group of identical characters.