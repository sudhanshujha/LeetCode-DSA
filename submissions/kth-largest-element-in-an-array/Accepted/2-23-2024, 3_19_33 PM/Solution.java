// https://leetcode.com/problems/kth-largest-element-in-an-array

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> data = new PriorityQueue<>(k+1);

        for(int i : nums){
            data.add(i);
            if(data.size()>k)   data.poll();
        }
        return data.poll();
    }
}