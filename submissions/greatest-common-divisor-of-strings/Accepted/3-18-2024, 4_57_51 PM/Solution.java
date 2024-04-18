// https://leetcode.com/problems/greatest-common-divisor-of-strings

class Solution {
    public String gcdOfStrings(String s, String t) {
        if (!(s + t).equals(t + s)) {
            return "";
        }
        int gcdLength = gcd(s.length(), t.length());
        return s.substring(0, gcdLength);
    }
    
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
