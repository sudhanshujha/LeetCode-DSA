// https://leetcode.com/problems/single-number

// 1. using hashmaps wherever fre =1 return - O(n) space
// 2. Sort the array.
// Traverse the array and check if one of the adjacent elements is equal to the current element or not.
// If yes , move ahead. Else return the current element.

// class Solution {
//     public int singleNumber(int[] nums) {
//         Arrays.sort(nums);
//         int n =nums.length;
//         for(int i=1; i<n; i+=2){
//             if(nums[i-1]!=nums[i])
//                 return nums[i-1]; 
//         }
//         return nums[n-1];
//     }
// }

class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i:nums){
            ans^=i;
        }
        return ans;
    }
}