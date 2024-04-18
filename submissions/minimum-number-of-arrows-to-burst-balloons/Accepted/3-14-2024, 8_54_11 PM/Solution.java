// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons

import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1])); // Sort balloons by ending points
        
        int arrows = 1; // At least one arrow is required
        int end = points[0][1]; // Ending point of the first balloon
        
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) { // Current balloon cannot be burst with the current arrow
                arrows++; // Increment arrow count
                end = points[i][1]; // Update end point
            } else { // Current balloon can be burst with the current arrow
                end = Math.min(end, points[i][1]); // Update end point
            }
        }
        
        return arrows;
    }
}
