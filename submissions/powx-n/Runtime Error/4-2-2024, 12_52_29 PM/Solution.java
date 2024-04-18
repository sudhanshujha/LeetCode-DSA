// https://leetcode.com/problems/powx-n

class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n % 2 == 0) {
            double half = myPow(x, n / 2);
            return half * half;
        } else {
            return x * myPow(x, n - 1);
        }
    }
}
