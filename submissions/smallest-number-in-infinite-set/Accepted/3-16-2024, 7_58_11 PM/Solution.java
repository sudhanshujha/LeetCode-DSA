// https://leetcode.com/problems/smallest-number-in-infinite-set

class SmallestInfiniteSet {

    boolean[] nums = new boolean[1001];
    int low = 1;

    public SmallestInfiniteSet() {
        // initialize all to true
        Arrays.fill(nums, true);
    }
    
    public int popSmallest() {
        // mark lower as popped
        nums[low] = false;
        int t = low++;

        // move to next smaller untill it is present
        while(low < nums.length - 1 && !nums[low]) low++;
        return t;        
    }
    
    public void addBack(int num) {

        // store num in low if is smaller
        if(num < low) low = num;
        
        // num marked as present
        nums[num] = true;
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */