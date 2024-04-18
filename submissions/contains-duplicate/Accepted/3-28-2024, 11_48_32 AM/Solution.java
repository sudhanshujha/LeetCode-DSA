// https://leetcode.com/problems/contains-duplicate

// sort - n logn, 1
// set - n, n
// hashmap - n, n

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for(int i: nums){
            if(s.contains(i))
                return true;
            s.add(i);
        }
        return false;
    }
}