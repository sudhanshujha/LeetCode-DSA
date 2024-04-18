// https://leetcode.com/problems/valid-anagram

class Solution {
    public boolean isAnagram(String s, String t) {
        // make char array & use that as hash map with count of each character
        // stack another way:     
        // set - not possible but, 
        // sort is another way
        // HashMap<Character, Integer> h = new HashMap<>();

        int a[] = new int[26];
        // for(int i = 0; i < 26; i++){
        //     a[i] = 0;
        // }
        for(char c: s.toCharArray()){
            a[c-'a']++;
        }
        for(char c: t.toCharArray()){
            a[c-'a']--;  
        }
        for(int i = 0; i < 26; i++){
            if(a[i] >= 1)
                return false;
        }
        return true;
    }
}