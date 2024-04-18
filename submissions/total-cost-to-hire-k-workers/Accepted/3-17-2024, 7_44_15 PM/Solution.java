// https://leetcode.com/problems/total-cost-to-hire-k-workers

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int i = 0;
        int j = costs.length - 1;
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();

        long ans = 0;
        while (k-- > 0) {
            while (left.size() < candidates && i <= j) {
                left.offer(costs[i++]);
            }
            while (right.size() < candidates && i <= j) {
                right.offer(costs[j--]);
            }

            int t1 = left.size() > 0 ? left.peek() : Integer.MAX_VALUE;
            int t2 = right.size() > 0 ? right.peek() : Integer.MAX_VALUE;

            if (t1 <= t2) {
                ans += t1;
                left.poll();
            } else {
                ans += t2;
                right.poll();
            }
        }
        return ans;
    }
}