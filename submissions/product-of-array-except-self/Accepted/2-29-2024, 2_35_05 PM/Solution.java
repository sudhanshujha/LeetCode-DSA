// https://leetcode.com/problems/product-of-array-except-self

// O(n) time
// O(1) extra space complexity
// Division not allowed as product/(nums[i]) will give java.lang.ArithmeticException: / by zero
// O(n^2) Calc left & right side product & store it in answer[i]

// prefix & suffix product 
// pre[i] = pre[i - 1] * a[i - 1] and similarly suff[i] = suff[i + 1] * a[i + 1].

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];
        int suff[] = new int[n];
        pre[0] = 1;
        suff[n - 1] = 1;
        
        for(int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for(int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i + 1];
        }
        
        int ans[] = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = pre[i] * suff[i];
        }
        return ans;
    }
}