// https://leetcode.com/problems/dota2-senate

class Solution {
    public String predictPartyVictory(String senate) {
        int radiantCount = 0; // Count of Radiant senators
        int direCount = 0;    // Count of Dire senators
        
        // Count the number of Radiant and Dire senators
        for (char c : senate.toCharArray()) {
            if (c == 'R') {
                radiantCount++;
            } else {
                direCount++;
            }
        }
        
        int n = senate.length();
        int banRadiant = 0; // Bans remaining for Radiant senators
        int banDire = 0;    // Bans remaining for Dire senators
        
        // Voting process
        for (int i = 0; i < n; i++) {
            char c = senate.charAt(i);
            if (c == 'R') {
                if (banRadiant > 0) { // Radiant senator is banned
                    banRadiant--;
                    radiantCount--;
                } else { // Ban a Dire senator
                    banDire++;
                }
            } else {
                if (banDire > 0) { // Dire senator is banned
                    banDire--;
                    direCount--;
                } else { // Ban a Radiant senator
                    banRadiant++;
                }
            }
            
            // Check if any party is eliminated
            if (radiantCount == 0) return "Dire"; // All Radiant senators are banned
            if (direCount == 0) return "Radiant"; // All Dire senators are banned
        }
        
        // Return the victory for the party with more remaining senators
        return radiantCount > direCount ? "Radiant" : "Dire";
    }
}
