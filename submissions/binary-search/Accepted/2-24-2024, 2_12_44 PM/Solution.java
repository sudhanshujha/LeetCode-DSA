// https://leetcode.com/problems/binary-search

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        if(low==high && nums[low]==target) return low;
        int mid;
        while(low<=high){
            mid = (low+high)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) low=mid+1;
            else high=mid-1;
        }
        return -1;
    }
}