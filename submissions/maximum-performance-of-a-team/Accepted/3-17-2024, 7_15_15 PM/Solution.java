// https://leetcode.com/problems/maximum-performance-of-a-team

import java.util.*;

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        final long MOD = 1_000_000_007;
        
        // Create a list of pairs to store efficiency and speed together
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(efficiency[i], speed[i]));
        }
        
        // Sort the pairs by efficiency in descending order
        Collections.sort(pairs, new PairComparator());
        
        // Create a min heap to store the speeds
        PriorityQueue<Integer> speedHeap = new PriorityQueue<>();
        
        long speedSum = 0;
        long maxPerformance = 0;
        
        // Iterate through the pairs
        for (Pair pair : pairs) {
            speedSum += pair.speed;
            speedHeap.offer(pair.speed);
            
            // If the size of the heap exceeds k, remove the smallest speed
            if (speedHeap.size() > k) {
                speedSum -= speedHeap.poll();
            }
            
            // Update the maximum performance
            maxPerformance = Math.max(maxPerformance, speedSum * pair.efficiency);
        }
        
        // Return the maximum performance modulo MOD
        return (int) (maxPerformance % MOD);
    }
    
    // Custom comparator class for sorting pairs by efficiency in descending order
    class PairComparator implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            return b.efficiency - a.efficiency;
        }
    }
    
    // Pair class to store efficiency and speed together
    class Pair {
        int efficiency;
        int speed;
        
        public Pair(int efficiency, int speed) {
            this.efficiency = efficiency;
            this.speed = speed;
        }
    }
}
