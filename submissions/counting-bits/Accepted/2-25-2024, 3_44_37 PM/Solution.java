// https://leetcode.com/problems/counting-bits

//Dynamic Programming with Bit Manipulation
//https://leetcode.com/problems/counting-bits/?envType=study-plan-v2&envId=leetcode-75

public class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}