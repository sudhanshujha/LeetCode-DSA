// https://leetcode.com/problems/valid-anagram

// class Solution {
//     public boolean isAnagram(String s, String t) {
//         // make char array & use that as hash map with count of each character
//         // stack another way:     
//         // set - not possible
//         // HashMap<Character, Integer> h = new HashMap<>();
//         int a[] = new int[26];
//         int m = s.length();
//         int n = t.length();
//         for(int i = 0; i < 26; i++){
//             a[i] = 0;
//         }
//         while(m > 0){
//             a[(s.charAt(m)-'a')]++;
//             m--;
//         }
//         while(n > 0){
//             a[(s.charAt(n)-'a')]--;  
//             n--;
//         }
//         for(int i = 0; i < 26; i++){
//             if(a[i] == 1)
//                 return false;
//         }
//         return true;
//     }
// }

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        
        // Count occurrences of each character in s
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        // Subtract occurrences of each character in t
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }
        
        // Check if all counts are 0
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}
