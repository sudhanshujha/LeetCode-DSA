// https://leetcode.com/problems/maximum-performance-of-a-team

import java.util.*;

class Solution {
    public int maxPerformance(int n, int[] s, int[] e, int k) {
        // final long MOD = 1_000_000_007;
        
        // Create an array of pairs to store efficiency and speed together
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = e[i];  // Efficiency
            pairs[i][1] = s[i];  // Speed
        }
        
        // Sort the pairs by efficiency in descending order
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);
        
        // Create a min heap to store the speeds
        PriorityQueue<Integer> speedHeap = new PriorityQueue<>();
        
        long speedSum = 0;
        long maxPerformance = 0;
        
        // Iterate through the pairs
        for (int[] pair : pairs) {
            speedSum += pair[1];
            speedHeap.offer(pair[1]);
            
            // If the size of the heap exceeds k, remove the smallest speed
            if (speedHeap.size() > k) {
                speedSum -= speedHeap.poll();
            }
            
            // Update the maximum performance
            maxPerformance = Math.max(maxPerformance, speedSum * pair[0]);
        }
        
        // Return the maximum performance modulo MOD
        return (int) (maxPerformance % (long)(1e9 + 7));
    }
}