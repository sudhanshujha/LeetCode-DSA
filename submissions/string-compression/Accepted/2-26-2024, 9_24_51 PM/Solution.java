// https://leetcode.com/problems/string-compression

class Solution {
    public int compress(char[] chars) {
        int index = 0, i = 0;
        while (i < chars.length) {
            char current = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == current) {
                count++;
                i++;
            }
            chars[index++] = current;
            if (count > 1)
                for (char c : ("" + count).toCharArray()) 
                    chars[index++] = c;
        }
        return index;
    }
}
