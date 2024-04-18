// https://leetcode.com/problems/nearest-exit-from-entrance-in-maze

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class MazeRecord {
        int row;
        int col;
        int distance;

        public MazeRecord(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Directions: right, down, left, up

        Queue<MazeRecord> queue = new LinkedList<>();
        queue.offer(new MazeRecord(entrance[0], entrance[1], 0));
        maze[entrance[0]][entrance[1]] = ','; // Mark entrance as visited

        while (!queue.isEmpty()) {
            MazeRecord record = queue.poll();
            int x = record.row;
            int y = record.col;
            int distance = record.distance;

            if ((x != entrance[0] || y != entrance[1]) && (x == 0 || x == rows - 1 || y == 0 || y == cols - 1)) {
                return distance; // Found exit
            }

            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && maze[newX][newY] == '.') {
                    maze[newX][newY] = ','; // Mark visited
                    queue.offer(new MazeRecord(newX, newY, distance + 1));
                }
            }
        }

        return -1; // No exit found
    }
}
