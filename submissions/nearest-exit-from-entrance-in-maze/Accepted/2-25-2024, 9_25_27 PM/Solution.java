// https://leetcode.com/problems/nearest-exit-from-entrance-in-maze

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Directions: right, down, left, up
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0}); // Cell coordinates and distance from entrance
        
        maze[entrance[0]][entrance[1]] = '+'; // Mark entrance as visited
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            int distance = cell[2];
            
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && maze[newX][newY] == '.') {
                    if (newX == 0 || newX == rows - 1 || newY == 0 || newY == cols - 1) {
                        return distance + 1; // Found exit
                    }
                    
                    maze[newX][newY] = '+'; // Mark visited
                    queue.offer(new int[]{newX, newY, distance + 1});
                }
            }
        }
        
        return -1; // No exit found
    }
}
