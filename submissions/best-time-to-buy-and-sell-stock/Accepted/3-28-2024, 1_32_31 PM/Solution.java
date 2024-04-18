// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

class Solution {
    public int maxProfit(int[] prices) {
       
        int curMin = 100000000; 
        int curMax = -1;
        int curDiff = 0;
        int maxDiff = 0;
        for(int i = 0; i < prices.length; i++) {

            if(prices[i] < curMin) {
                curMin = prices[i];
                curMax = -1;
            }
            
           if(prices[i] > curMax) {
                curMax = prices[i];
                curDiff = curMax - curMin;
               
                if(curDiff > maxDiff) {
                    maxDiff = curDiff;
                }
            } 


        }
           
        return maxDiff; 
    }
}