// https://leetcode.com/problems/daily-temperatures

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        
        // Initialize the answer array with 0
        for (int i = 0; i < n; i++) {
            answer[i] = 0;
        }
        
        for (int i = n - 2; i >= 0; i--) { // Start from the second last element
            int j = i + 1; // Start j from the next element
            
            // Iterate until we find a higher temperature or reach the end
            while (j < n && temperatures[j] <= temperatures[i]) {
                if (answer[j] != 0) {
                    j += answer[j]; // Skip to the next higher temperature if it's known
                } else {
                    j = n; // No higher temperature found
                }
            }
            
            // Update the answer for the current temperature
            if (j < n) {
                answer[i] = j - i; // Difference in indices
            }
        }
        
        return answer;
    }
}
