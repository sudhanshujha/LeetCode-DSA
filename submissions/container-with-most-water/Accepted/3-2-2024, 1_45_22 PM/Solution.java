// https://leetcode.com/problems/container-with-most-water

class Solution {
    //Two pointer system
    public int maxArea(int[] height) {
        //Start our pointers
        int left = 0;
        int right = height.length-1;
        
        //Start looping until we find the max 
        int maxArea  = 0;
        int currArea = 0;
        while(left<right){
            //Current Area is the minimum of the heights multiplied
            //by the horizontal distance
            currArea = (right-left)*Math.min(height[left],height[right]);
            maxArea = Math.max(maxArea, currArea);
            
            //try to maximize the area by increasing
            //left if its the one thats lower
            //or right if thats the one.
            if(height[left] < height[right]){
                left++;
            } else{
                right--;
            }
        }
        
        return maxArea;
    }
}