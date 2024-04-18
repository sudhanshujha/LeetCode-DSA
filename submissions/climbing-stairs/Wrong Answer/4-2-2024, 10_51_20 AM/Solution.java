// https://leetcode.com/problems/climbing-stairs

class Solution {
    public int climbStairs(int n) {
        // 1 -> n=1, [1]
        // 2 -> n=2, [1,1], [2]
        // 3 -> n=3, [1,1,1],[1,2]*2
        // 5 -> n=4, [1,1,1,1],[2,1,1]*3,[2,2]
        // 8 -> n=5, [1,1,1,1,1],[2,1,1,1]*4,[2,2,1]*3
        int a = 1, b = 2, temp;
        for (int i = 3; i <= n; i++){
            temp = b;
            b = a + b;
            a = temp;
        }
        return b;
    }
}