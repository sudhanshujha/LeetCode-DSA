// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int buy = -prices[0]; // Initialize buy as if we bought the stock on the first day
        int sell = 0; // Initialize sell as 0

        for (int i = 1; i < n; i++) {
            // Update buy and sell based on whether we buy or sell the stock on the current day
            buy = Math.max(buy, sell - prices[i]);
            sell = Math.max(sell, buy + prices[i] - fee);
        }

        // The maximum profit will be the value of sell on the last day
        return sell;
    }
}
