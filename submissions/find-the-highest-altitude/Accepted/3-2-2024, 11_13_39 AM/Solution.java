// https://leetcode.com/problems/find-the-highest-altitude

class Solution {
    public int largestAltitude(int[] gain) {
        // cumulative store - prefix sum
        int n = gain.length;
        // a for altitudes array
        int max = 0;
        int x=0;
        for(int i=1; i<=n; i++){
            x = gain[i-1] + x;
            if(x>max)
                max=x;
        }
        return max;
    }
}