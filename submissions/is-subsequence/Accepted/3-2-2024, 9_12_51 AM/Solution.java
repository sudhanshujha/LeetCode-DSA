// https://leetcode.com/problems/is-subsequence

class Solution {
    public boolean isSubsequence(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        int i = 0, j = 0;
        // check if s is subsequence of t
        while (i < tl && j < sl) {
            if (s.charAt(j) == t.charAt(i))
                j++;
            i++;
        }
        return j == sl;
    }
}