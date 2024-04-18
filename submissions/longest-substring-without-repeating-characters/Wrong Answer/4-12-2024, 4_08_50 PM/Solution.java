// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        // Sliding Window
        for (char c: s.toCharArray()){
            if(set.contains(c)){
                max = Math.max(max, set.size());
                set.clear();
            }
            set.add(c);

        }
        return max;
    }
}