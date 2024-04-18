// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int left = 0; // Starting index of the current substring
        // Sliding Window
        for (char c : s.toCharArray()) {
            // If the character is already in the set, move the left pointer to the right
            // until the duplicate character is removed from the set
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            // Add the current character to the set
            set.add(c);
            // Update the maximum length of the substring
            max = Math.max(max, set.size());
        }
        return max;
    }
}
