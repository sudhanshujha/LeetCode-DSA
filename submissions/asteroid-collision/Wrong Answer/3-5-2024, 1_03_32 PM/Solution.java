// https://leetcode.com/problems/asteroid-collision

import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // Note: direction (positive meaning right, negative meaning left) so if all -ve are in left & +ve in right no collision
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
            } else if ((a.get(i) + a.get(i - 1) == 0) && a.get(i) < 0) { // opp sign, right negative & equal both destroyed
                a.remove(i);
                a.remove(i - 1);
            } else if ((a.get(i) + a.get(i - 1) == 0) && a.get(i) > 0){
                continue;
            } 
            else { // opp sign & unequal -> abs bigger one will survive
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
