// https://leetcode.com/problems/reverse-string

class Solution {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        solve(s, i, j);
    }
    public void solve(char[] s, int i, int j){
        if (i >= j) return;
        // swap
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        solve(s, i+1, j-1);
    }
}