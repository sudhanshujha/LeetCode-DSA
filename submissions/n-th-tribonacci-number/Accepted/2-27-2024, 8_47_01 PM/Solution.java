// https://leetcode.com/problems/n-th-tribonacci-number

class Solution {
    public int tribonacci(int n) {
        int t0 = 0, t1 = 1, t2 = 1, t3;
        if (n == 0) return t0;
        if (n == 1 || n == 2) return t1;

        for (int i = 3; i <= n; i++) {
            t3 = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = t3;
        }

        return t2;
    }
}