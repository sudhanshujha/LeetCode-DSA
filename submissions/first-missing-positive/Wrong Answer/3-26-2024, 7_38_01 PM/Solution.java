// https://leetcode.com/problems/first-missing-positive

class Solution {
    public int firstMissingPositive(int[] nums) {
        int m = 1;
        for(int i: nums){
            if(i == m)
                m++;
        }
        return m;
    }
}