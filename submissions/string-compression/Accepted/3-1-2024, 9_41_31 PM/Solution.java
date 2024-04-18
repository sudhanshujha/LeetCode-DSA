// https://leetcode.com/problems/string-compression

class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        StringBuilder s = new StringBuilder();
        //  If the group's length is 1
        if(n==1) return 1;

        int i=0, freq;   // 2 pointer 1 iterates other keep updating the freq
        while (i<n) {
            freq = 1;
            s.append(chars[i]);
            while (i < n-1 && chars[i] == chars[i + 1]) {
                i++;
                freq++;
            }
            // check if freq is converted into string
            
            if(freq>1){
                s.append(freq);
            }
            
            //  group lengths that are 10 or 100 or longer will be split into multiple characters in chars 
            // but moving from stringbuilder to char array during iteration will take care   
            
            i++; // Increment i to move to the next character
        }
        // copy s to chars when you face any number then enter them one by one in chars array
        for (int j = 0; j < s.length(); j++) {
            chars[j] = s.charAt(j);
        }
        return s.length();
    }             
}
