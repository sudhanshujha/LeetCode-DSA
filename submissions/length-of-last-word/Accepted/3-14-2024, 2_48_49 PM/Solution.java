// https://leetcode.com/problems/length-of-last-word

class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ')
            i--;  
        int j = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            j++;
            i--;
        }
        return j;
    }
}
