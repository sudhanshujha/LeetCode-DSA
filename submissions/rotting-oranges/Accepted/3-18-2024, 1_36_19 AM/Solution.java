// https://leetcode.com/problems/rotting-oranges

import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int countRot = 0, countFresh = 0, time = 0;
        Queue<int[]> queue = new LinkedList<>();

        // Count the number of fresh and rotten oranges, and add rotten oranges to the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    countRot++;
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Directions: right, down, left, up

        // Perform BFS to simulate rotting process
        while (!queue.isEmpty() && countFresh > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0], y = curr[1];
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2; // Mark the adjacent fresh orange as rotten
                        queue.offer(new int[]{nx, ny});
                        countFresh--;
                    }
                }
            }
            time++;
        }

        return countFresh == 0 ? time : -1; // Return time if all oranges are rotten, otherwise -1
    }
}
