// https://leetcode.com/problems/find-the-highest-altitude

class Solution {
    public int largestAltitude(int[] gain) {
        int altitude = 0;
        int maxAltitude = 0;
        for (int gainValue : gain) {
            altitude += gainValue;
            maxAltitude = Math.max(maxAltitude, altitude);
        }
        return maxAltitude;
    }
}
