// https://leetcode.com/problems/edit-distance

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] dp = new int[n + 1];

        // Initialize the DP table
        for (int j = 0; j <= n; j++) {
            dp[j] = j;
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            int prev = dp[0];
            dp[0] = i;
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = prev;
                } else {
                    dp[j] = 1 + Math.min(Math.min(dp[j], dp[j - 1]), prev);
                }
                prev = temp;
            }
        }

        return dp[n];
    }
}
