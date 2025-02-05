// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons

import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        
        int n = points.length;
        int count = 1;
        
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int end = points[0][1];
        
        for (int i = 1; i < n; i++) {
            if (points[i][0] > end) {
                count++;
                end = points[i][1];
            }
        }
        
        return count;
    }
}
