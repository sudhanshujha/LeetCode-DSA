// https://leetcode.com/problems/word-search

import java.util.*;

class Solution {
    public boolean exist(char[][] board, String word) {
        // Step 1: Put all characters from the word into a set
        Set<Character> charSet = new HashSet<>();
        for (char c : word.toCharArray()) {
            charSet.add(c);
        }

        // Step 2: Iterate through the matrix and fill a hashmap with row and column of characters
        HashMap<Character, List<int[]>> charMap = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (charSet.contains(board[i][j])) {
                    charMap.putIfAbsent(board[i][j], new ArrayList<>());
                    charMap.get(board[i][j]).add(new int[]{i, j});
                }
            }
        }

        // Step 3: Perform DFS search to find the word
        return dfs(board, word, charMap, new HashSet<>(), 0, -1, -1);
    }

    private boolean dfs(char[][] board, String word, HashMap<Character, List<int[]>> charMap, Set<String> visited, int index, int row, int col) {
        if (index == word.length()) {
            return true; // Found the entire word
        }

        char currentChar = word.charAt(index);
        if (!charMap.containsKey(currentChar)) {
            return false; // Current character not found in the matrix
        }

        for (int[] pos : charMap.get(currentChar)) {
            int newRow = pos[0];
            int newCol = pos[1];
            if (!visited.contains(newRow + "," + newCol) && (row == -1 || isValidAdjacent(row, col, newRow, newCol))) {
                visited.add(newRow + "," + newCol);
                if (dfs(board, word, charMap, visited, index + 1, newRow, newCol)) {
                    return true;
                }
                visited.remove(newRow + "," + newCol);
            }
        }

        return false;
    }

    private boolean isValidAdjacent(int row1, int col1, int row2, int col2) {
        return Math.abs(row1 - row2) + Math.abs(col1 - col2) == 1;
    }
}
