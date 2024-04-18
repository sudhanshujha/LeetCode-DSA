// https://leetcode.com/problems/daily-temperatures

class Solution {
    public int[] dailyTemperatures(final int[] temps) {
        final int[] result = new int[temps.length];

        for (int i=result.length-1; i>=0; i--) {
            int j = i+1;
            while(j < result.length) {
                if (temps[j] > temps[i]) {
                    result[i] = j-i;
                    break;
                } else if (result[j] == 0) {
                    break;
                } else {
                    j += result[j];
                }
            }
        }
        
        return result;
    }
}