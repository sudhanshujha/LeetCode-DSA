// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length

class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < k; i++) {
            if(isVowel(s.charAt(i)))
                count++;
        }
        int i = 0;
        int j = k-1;
        int max = count;
        while(j < n - 1){
            j++;
            if(isVowel(s.charAt(j)))
                count++;
            if(isVowel(s.charAt(i)))
                count--;
            max = Math.max(max, count);
            i++;
        }
        return max;
    }
    
    public static boolean isVowel(char ch) 
    { 
        switch (ch) { 
            case 'a': 
            case 'e': 
            case 'i': 
            case 'o': 
            case 'u': 
                return true; 
            default:
                return false;
        } 
    } 
}
