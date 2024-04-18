// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0, size = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!set.contains(c)){
                set.add(c);
            }
            else{
                if(max < set.size()) max = set.size();
                set.clear();
                set.add(c);
            }    
        }
        return max;
    }
}