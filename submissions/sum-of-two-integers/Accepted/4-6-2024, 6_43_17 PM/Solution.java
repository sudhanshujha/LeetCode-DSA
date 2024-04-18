// https://leetcode.com/problems/sum-of-two-integers

class Solution {
    public int getSum(int a, int b) {
    // bitwise operators 
    return b==0? a:getSum(a^b, (a&b)<<1); 
    //be careful about the terminating condition;
    }
}