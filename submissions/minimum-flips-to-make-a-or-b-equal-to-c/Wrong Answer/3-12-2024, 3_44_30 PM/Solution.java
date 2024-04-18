// https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c

class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        for (int i = 0; i < 32; i++) {
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitC = (c >> i) & 1;
            if (((bitA | bitB) != bitC) && (bitC == 1 || (bitA == 1 && bitB == 1))) {
                if (bitA == 0 && bitB == 0) {
                    flips += 1;
                } else {
                    flips += 2;
                }
            }
        }
        return flips;
    }
}
