// https://leetcode.com/problems/container-with-most-water

class Solution {
    public int maxArea(int[] height) {
        // int area = width * min(height[i], height[j])
        int i=0, j=height.length-1, max = 0;   // h for min height & w for width

        while(j>i){
            // h = Math.min(height[i],height[j]);
            // a = (j-i)*h;
            // area = (j-i)*Math.min(height[i],height[j]
            max = Math.max((j-i)*Math.min(height[i],height[j]),max);
            if(height[i]>height[j]) // cannot leave i bade log
                j--;
            else
                i++;
        }
        return max;
    }
}

// MIN(a[i],a[j])*(j-i)=min(a[0],a[1]*width)= min(1,8)*width = 1*1
// min(1,6)*width = 1*1