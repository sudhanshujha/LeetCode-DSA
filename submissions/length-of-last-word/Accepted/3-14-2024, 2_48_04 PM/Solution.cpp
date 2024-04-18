// https://leetcode.com/problems/length-of-last-word

class Solution {
public:
    int lengthOfLastWord(string s) {
        int i = s.length() - 1;
        while (i >= 0 && s[i] == ' ')
            i--;
        int j = 0;
        while (i >= 0 && s[i] != ' ') {
            j++;
            i--;
        }
        return j;
    }
};
