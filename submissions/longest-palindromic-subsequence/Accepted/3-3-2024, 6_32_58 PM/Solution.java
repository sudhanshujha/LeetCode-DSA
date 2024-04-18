// https://leetcode.com/problems/longest-palindromic-subsequence

class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sr = new StringBuilder(s).reverse();
        return longestCommonSubsequence(s, sr.toString());
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[] prev = new int[n+1];
        int[] curr;
        for(int i=1; i<m+1; i++){
            curr = new int[n+1];
            for(int j=1; j<n+1; j++){
                if(text1.charAt(i-1)== text2.charAt(j-1)) curr[j] = 1+prev[j-1];
                else curr[j]  =  Math.max(prev[j], curr[j-1]);
            }
            prev = curr;
        }
        return prev[n];
    }

}
