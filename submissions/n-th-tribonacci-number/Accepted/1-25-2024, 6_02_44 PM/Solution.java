// https://leetcode.com/problems/n-th-tribonacci-number

class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int t2 = 1, t1 = 1, t0 = 0;

        for (int i = 3; i <= n; i++) {
            int t3 = t2 + t1 + t0;
            t0 = t1;
            t1 = t2;
            t2 = t3;
        }
        return t2;
    }
}
