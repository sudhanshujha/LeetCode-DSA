// https://leetcode.com/problems/find-the-difference-of-two-arrays

import java.util.*;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // Move all elements of both arrays to 2 hashsets
        // answer[0] = nums1 set - intersection of nums1 and nums2
        // answer[1] = nums2 set - intersection of nums2 and nums1

        HashSet<Integer> nums1Set = new HashSet<>();
        HashSet<Integer> nums2Set = new HashSet<>();

        for (Integer i : nums1) {
            nums1Set.add(i);
        }

        for (Integer i : nums2) {
            nums2Set.add(i);
        }

        // Find the intersection of nums1Set and nums2Set
        HashSet<Integer> answerSet = new HashSet<>(nums1Set);
        answerSet.retainAll(nums2Set);

        // Remove intersection elements from nums1Set and nums2Set
        nums1Set.removeAll(answerSet);
        nums2Set.removeAll(answerSet);

        // Convert sets to lists
        List<Integer> onlyInNums1 = new ArrayList<>(nums1Set);
        List<Integer> onlyInNums2 = new ArrayList<>(nums2Set);

        // Create the result list
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(onlyInNums1);
        answer.add(onlyInNums2);

        return answer;
    }
}
