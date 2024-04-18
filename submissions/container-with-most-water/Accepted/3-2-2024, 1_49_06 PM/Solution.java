// https://leetcode.com/problems/container-with-most-water

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0, j = n-1;
        int maxArea = 0;
        while(i<j){
            maxArea = Math.max(maxArea,
            (j-i)*Math.min(height[i], height[j]));
            if(height[i]<height[j]) i++;
            else j--;
        }
        return maxArea;
    }
}