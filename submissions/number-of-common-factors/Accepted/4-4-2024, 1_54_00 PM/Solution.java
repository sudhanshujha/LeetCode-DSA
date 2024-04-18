// https://leetcode.com/problems/number-of-common-factors

class Solution {
    public int commonFactors(int a, int b) {
        int x = gcd(a, b);
        int count = 0;
        // Count common factors of a and b
        for (int i = 1; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                if (a % i == 0 && b % i == 0) {
                    count++;
                }
                if (i != x / i && a % (x / i) == 0 && b % (x / i) == 0) {
                    count++;
                }
            }
        }
        return count;
    }
    
    // Find gcd
    public static int gcd(int a, int b) {
        if (a % b == 0)
            return b;
        if (a < b)
            return gcd(b, a);
        return gcd(a % b, b);
    }
}
