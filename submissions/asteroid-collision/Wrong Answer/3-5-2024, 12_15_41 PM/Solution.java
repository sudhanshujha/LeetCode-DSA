// https://leetcode.com/problems/asteroid-collision

import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // Convert int[] array to ArrayList<Integer>
        List<Integer> a = new ArrayList<>();
        for (int asteroid : asteroids) {
            a.add(asteroid);
        }
        
        int n = a.size();
        for (int i = n - 1; i > 0; i--) {
            // if same sign then no collision will occur
            if (a.get(i) * a.get(i - 1) > 0) {
                continue;
            } else if (a.get(i) + a.get(i - 1) == 0) { // opp sign & equal both destroyed
                a.remove(i);
                a.remove(i - 1);
            } else { // opp sign & unequal -> abs bigger one will survive
                if (Math.abs(a.get(i)) > Math.abs(a.get(i - 1))) {
                    a.remove(i - 1);
                } else {
                    a.remove(i);
                }
            }
        }
        
        // Convert ArrayList to int[] using Java streams
        return a.stream().mapToInt(Integer::intValue).toArray();
    }
}
