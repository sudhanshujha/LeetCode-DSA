// https://leetcode.com/problems/counting-bits

import java.util.*;

class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1]; // Create array to store results
        
        for (int i = 0; i <= n; i++) {
            ans[i] = countOne(i); // Calculate count of set bits for each number
        }

        return ans;
    }

    int countOne(int n) {
        int count = 0; // Initialize count within the function
        
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        
        return count;
    }
}
