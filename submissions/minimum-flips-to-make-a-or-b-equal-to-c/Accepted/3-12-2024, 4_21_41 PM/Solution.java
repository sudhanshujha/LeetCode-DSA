// https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c

class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        for (int i = 0; i < 32; i++) {
            int bitC = (c >> i) & 1;
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            if (bitC == 0) {
                if (bitA == 1 && bitB == 1) {
                    flips += 2; // Need to flip both a and b
                } else if (bitA == 1 || bitB == 1) {
                    flips += 1; // Need to flip one of a or b
                }
            } else {
                if (bitA == 0 && bitB == 0) {
                    flips += 1; // Need to flip either a or b
                }
            }
        }
        return flips;
    }
}
