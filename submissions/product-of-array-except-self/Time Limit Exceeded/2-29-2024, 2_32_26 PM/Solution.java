// https://leetcode.com/problems/product-of-array-except-self

// TC: O(n^2)
// loop through the complete array using a pointer, say j, for every index i, and multiply all the elements at index j except when i == j. 
// This would ensure that I skip the element at index i from being multiplied.
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        
        for(int i = 0; i < n; i++) {
            int pro = 1;
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                pro *= nums[j];
            }
            ans[i] = pro;
        }
        
        return ans;
    }
}