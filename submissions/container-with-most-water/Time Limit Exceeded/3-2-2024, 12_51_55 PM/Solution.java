// https://leetcode.com/problems/container-with-most-water

class Solution {
    public int maxArea(int[] height) {
        // int area = width * min(height[i], height[j])
        int h, w, a, max = 0, n = height.length;   // h for min height & w for width
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                h = Math.min(height[i],height[j]);
                a = (j-i)*h;
                max = Math.max(a,max);
            }
        }
        return max;
    }
}

// height = [1,8,6,2,5,4,8,3,7]

// MIN(a[i],a[j])*(j-i)=min(a[0],a[1]*width)= min(1,8)*width = 1*1
// min(1,6)*width = 1*1
// min(1,8)*width = 1*1
// all from index=0 
// al from 