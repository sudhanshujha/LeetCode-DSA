// https://leetcode.com/problems/is-subsequence

class Solution {
    public boolean isSubsequence(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        int j = 0;
        
        for (int i = 0; i < tl && j < sl; i++) {
            if (s.charAt(j) == t.charAt(i)) {
                j++;
            }
        }
        
        return j == sl;
    }
}
