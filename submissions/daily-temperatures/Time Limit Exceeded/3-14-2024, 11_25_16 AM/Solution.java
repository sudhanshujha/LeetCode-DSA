// https://leetcode.com/problems/daily-temperatures

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && temperatures[j] <= temperatures[i]) {
                j++;
            }
            if (j < n) {
                answer[i] = j - i;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }
}
