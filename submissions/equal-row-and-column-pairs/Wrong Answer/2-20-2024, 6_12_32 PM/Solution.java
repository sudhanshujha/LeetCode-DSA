// https://leetcode.com/problems/equal-row-and-column-pairs

import java.util.*;

class Solution {
        int count = 0;

    public int equalPairs(int[][] grid) {
        // Create a hashmap to store occurrences of rows and columns
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();

        // Count occurrences of rows and columns
        for (int[] row : grid) {
            int rowHash = Arrays.hashCode(row);
            rowMap.put(rowHash, rowMap.getOrDefault(rowHash, 0) + 1);
        }

        for (int j = 0; j < grid[0].length; j++) {
            int[] col = new int[grid.length];
            for (int i = 0; i < grid.length; i++) {
                col[i] = grid[i][j];
            }
            int colHash = Arrays.hashCode(col);
            colMap.put(colHash, colMap.getOrDefault(colHash, 0) + 1);
        }

        // // Print keys and values
        // System.out.println("RowMap");
        // for (int key : rowMap.keySet()) {
        //     System.out.println("key: " + key + " value: " + rowMap.get(key));
        // }

        // System.out.println("ColMap");
        // for (int key : colMap.keySet()) {
        //     System.out.println("key: " + key + " value: " + colMap.get(key));
        // }


        for (int key : rowMap.keySet()) {
            if (colMap.containsKey(key)) {
                count += rowMap.get(key)*colMap.get(key);
            }
        }

        return count;
    }

}
