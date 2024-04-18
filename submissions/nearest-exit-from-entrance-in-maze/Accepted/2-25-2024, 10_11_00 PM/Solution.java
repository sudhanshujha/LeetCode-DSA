// https://leetcode.com/problems/nearest-exit-from-entrance-in-maze

import java.util.*;

// using djikstra
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Right, Down, Left, Up
        
        // Initialize distances array to store shortest distances from entrance to each cell
        int[][] distances = new int[rows][cols];
        for (int[] row : distances) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        // Initialize priority queue to store cells based on their distances from the entrance
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); // {row, col, distance}
        pq.offer(new int[]{entrance[0], entrance[1], 0}); // Add entrance to the priority queue
        distances[entrance[0]][entrance[1]] = 0; // Set distance to entrance as 0
        
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int x = cell[0];
            int y = cell[1];
            int distance = cell[2];
            
            // Explore neighbors in all four directions
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                // Check if the neighbor is within the maze bounds and is an empty cell
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && maze[newX][newY] == '.') {
                    // Update distance if a shorter path is found
                    if (distance + 1 < distances[newX][newY]) {
                        distances[newX][newY] = distance + 1;
                        pq.offer(new int[]{newX, newY, distance + 1});
                        
                        // If the exit is reached and it's not the entrance, return the distance
                        if ((newX == 0 || newX == rows - 1 || newY == 0 || newY == cols - 1) && (newX != entrance[0] || newY != entrance[1])) {
                            return distances[newX][newY];
                        }
                    }
                }
            }
        }
        
        return -1; // No exit found
    }
}
