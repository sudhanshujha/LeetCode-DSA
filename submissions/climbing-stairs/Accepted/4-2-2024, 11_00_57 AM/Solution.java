// https://leetcode.com/problems/climbing-stairs

class Solution {
    public int climbStairs(int n) {
        // 1 -> n=1, [1]
        // 2 -> n=2, [1,1], [2]
        // 3 -> n=3, [1,1,1],[1,2]*2
        // 5 -> n=4, [1,1,1,1],[2,1,1]*3,[2,2]
        // 8 -> n=5, [1,1,1,1,1],[2,1,1,1]*4,[2,2,1]*3

        // Another way to observe: 
        // Ways to climb stairs, assune we are on the nth stair,
        // we can come from two options:
        // 1. either we climbed one stair from the (n-1)th stair or
        // 2. we climbed two stairs from the (n-2)th stair.
        // so, f(n) = f(n-1) + f(n-2)

        int a = 1, b = 2, temp;
        if (n == 0 || n == 1) return a;
        if (n==2) return b;
        for (int i = 3; i <= n; i++){
            temp = b;
            b = a + b;
            a = temp;
        }
        return b;
    }
}