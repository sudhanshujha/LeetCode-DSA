// https://leetcode.com/problems/subsets

class Solution {
    public static List<List<Integer>> subsets(int[] nums){ 
        List<List<Integer>> op = new ArrayList<>();
        helper(nums, 0, op, new ArrayList<>());
        return op;
    }

public static void helper(int[] nums, int index, List<List<Integer>> op, List<Integer> curr){
       if(index>nums.length-1){ 
           op.add(new ArrayList<>(curr));
            return; 
       } 
       curr.add(nums[index]);  
        helper(nums, index+1, op, curr);    
       curr.remove(curr.size()-1);   
       helper(nums, index+1, op, curr);
    }
}