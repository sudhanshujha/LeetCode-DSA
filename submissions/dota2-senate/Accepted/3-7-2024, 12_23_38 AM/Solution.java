// https://leetcode.com/problems/dota2-senate

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();

        // Initialize queues for Radiant and Dire senators
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') radiant.offer(i);
            else dire.offer(i);
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantIndex = radiant.poll();
            int direIndex = dire.poll();

            // The senator who bans the other senator will skip the next round
            if (radiantIndex < direIndex) radiant.offer(radiantIndex + n);
            else dire.offer(direIndex + n);
        }

        // Return the party that still has senators in the queue
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
