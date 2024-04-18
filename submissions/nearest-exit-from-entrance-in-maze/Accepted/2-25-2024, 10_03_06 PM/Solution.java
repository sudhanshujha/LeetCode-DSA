// https://leetcode.com/problems/nearest-exit-from-entrance-in-maze

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length, cols = maze[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Directions: right, down, left, up
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0}); // Add entrance cell to the queue with initial distance 0
        maze[entrance[0]][entrance[1]] = '+'; // Mark entrance as visited
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll(); // Dequeue the cell
            int x = cell[0], y = cell[1], distance = cell[2]; // Extract cell coordinates and distance
            
            // Explore neighbors in all four directions
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1]; // Calculate new coordinates
                // Check if the new coordinates are within the maze boundaries and the cell is empty
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && maze[nx][ny] == '.') {
                    // If the exit is found and it's not the entrance, return the distance
                    if ((nx == 0 || nx == rows - 1 || ny == 0 || ny == cols - 1) && (nx != entrance[0] || ny != entrance[1])) 
                        return distance + 1;
                    maze[nx][ny] = '+'; // Mark the cell as visited
                    queue.offer(new int[]{nx, ny, distance + 1}); // Enqueue the neighboring cell with increased distance
                }
            }
        }
        return -1; // No exit found
    }
}
