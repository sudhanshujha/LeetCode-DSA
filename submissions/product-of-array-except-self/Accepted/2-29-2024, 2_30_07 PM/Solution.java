// https://leetcode.com/problems/product-of-array-except-self

// O(n) time
// O(1) extra space complexity
// Division not allowed as product/(nums[i]) will give java.lang.ArithmeticException: / by zero
// O(n^2) Calc left & right side product & store it in answer[i]

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int leftProduct = 1;
        int rightProduct = 1;
        int n = nums.length;
        int answer[] = new int[n];

        for(int i=0; i<n; i++){
            answer[i] = leftProduct;
            leftProduct *= nums[i];
        }
        for(int i= n-1; i>=0; i--){
            answer[i] *= rightProduct;
            rightProduct *= nums[i]; 
        }
        return answer;
    }
}
