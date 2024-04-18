// https://leetcode.com/problems/find-peak-element

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int mid;
        if(nums.length==1) return 0;
        while(low<=high){
            mid = low + (high-low)/2;
            // base condition is if it is a peak element
            if(nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1])
                return mid;
            //else move to right to find peak if it is like 3 in 1,3,5
            else if(nums[mid-1]<nums[mid] && nums[mid]<nums[mid+1])
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
        
    }
}