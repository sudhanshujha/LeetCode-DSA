// https://leetcode.com/problems/powx-n

class Solution {
    public double myPow(double x, int n) {
        return myPowHelper(x, n, 1);
    }
    
    private double myPowHelper(double x, int n, double result) {
        if (n == 0) {
            return result;
        } else if (n % 2 == 0) {
            return myPowHelper(x * x, n / 2, result);
        } else {
            return myPowHelper(x, n - 1, result * x);
        }
    }
}
