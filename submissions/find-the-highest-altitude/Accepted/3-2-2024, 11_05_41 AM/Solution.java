// https://leetcode.com/problems/find-the-highest-altitude

class Solution {
    public int largestAltitude(int[] gain) {
        // cumulative store - prefix sum
        int n = gain.length;
        // a for altitudes array
        int a[] = new int[n+1];
        a[0] = 0; 
        int max = 0;
        for(int i=1; i<=n; i++){
            a[i] = gain[i-1] + a[i-1];
            if(a[i]>max)
                max=a[i];
        }
        return max;
    }
}