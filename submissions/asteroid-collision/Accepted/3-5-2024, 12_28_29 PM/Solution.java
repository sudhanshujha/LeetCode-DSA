// https://leetcode.com/problems/asteroid-collision

import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> ans = new ArrayList<>();
        int s = 0;
        while (s < asteroids.length) {
            int asteroid = asteroids[s];
            if (ans.size() == 0) {
                ans.add(asteroid);
                s++;
                continue;
            }
            int topi = ans.get(ans.size() - 1);
            if ((asteroid > 0 && topi > 0) || (asteroid < 0 && topi < 0)) {
                ans.add(asteroid);
                s++;
            } else {
                if (asteroid < 0) {
                    if (Math.abs(asteroid) == topi) {
                        ans.remove(ans.size() - 1);
                        s++;
                    } else if (Math.abs(asteroid) > topi) {
                        ans.remove(ans.size() - 1);
                    } else {
                        s++;
                    }
                } else {
                    ans.add(asteroid);
                    s++;
                }
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
