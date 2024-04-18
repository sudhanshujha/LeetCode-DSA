// https://leetcode.com/problems/number-of-common-factors

import java.lang.Math;

class Solution {
    public int commonFactors(int a, int b) {
        int x = gcd(a, b);
        System.out.print(x);
        int count = 0;
        // list all factors of GCD
        for (int i = 1; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                count += 2; // Add two factors for each pair found
                if (i == Math.sqrt(x)) {
                    count--; // Adjust the count for perfect squares
                }
            }
        }
        return count;
    }

    // find gcd
    public static int gcd(int a, int b) {
        if (a % b == 0)
            return b;
        if (a < b)
            return gcd(b, a);
        return gcd(a % b, b);
    }
}
