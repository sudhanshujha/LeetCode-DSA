// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length

class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length(), max = 0, count = 0;
        for (int i = 0; i < n; ++i) {
            count += "aeiou".indexOf(s.charAt(i)) >= 0 ? 1 : 0;
            if (i >= k) count -= "aeiou".indexOf(s.charAt(i - k)) >= 0 ? 1 : 0;
            max = Math.max(max, count);
        }
        return max;
    }
}
