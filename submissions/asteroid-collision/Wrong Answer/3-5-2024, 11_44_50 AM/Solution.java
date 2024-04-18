// https://leetcode.com/problems/asteroid-collision

import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int n = asteroids.length;
        stack.push(asteroids[0]);
        int i = 1;
        while (i < n) {
            if (stack.isEmpty() || asteroids[i] * stack.peek() > 0 || (asteroids[i] > 0 && stack.peek() < 0)) {
                stack.push(asteroids[i]);
            } else {
                while (!stack.isEmpty() && asteroids[i] * stack.peek() < 0 && stack.peek() > 0) {
                    int top = stack.pop();
                    if (Math.abs(top) == Math.abs(asteroids[i])) {
                        i++;
                    } else if (Math.abs(top) > Math.abs(asteroids[i])) {
                        // No collision, continue to next asteroid
                    } else {
                        // The current asteroid gets destroyed, check with the next asteroid
                        continue;
                    }
                }
            }
            i++;
        }
        
        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int j = stack.size() - 1; j >= 0; j--) {
            result[j] = stack.pop();
        }
        
        return result;
    }
}