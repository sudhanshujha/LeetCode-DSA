// https://leetcode.com/problems/word-search

import java.util.HashMap;

class Solution {
    public boolean exist(char[][] board, String word) {
        // Edge case: empty word
        if (word == null || word.length() == 0)
            return false;

        // Create a HashMap to store the coordinates of each character
        HashMap<Character, List<int[]>> charMap = new HashMap<>();

        // Traverse the board and populate the HashMap
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (!charMap.containsKey(c))
                    charMap.put(c, new ArrayList<>());
                charMap.get(c).add(new int[]{i, j});
            }
        }

        // Starting with the first character of the word, recursively search for the word
        return searchWord(board, word, 0, charMap, new boolean[board.length][board[0].length]);
    }

    // Recursive method to search for the word on the board
    private boolean searchWord(char[][] board, String word, int index, HashMap<Character, List<int[]>> charMap, boolean[][] visited) {
        if (index == word.length())
            return true;

        char c = word.charAt(index);
        if (!charMap.containsKey(c))
            return false;

        for (int[] pos : charMap.get(c)) {
            int row = pos[0];
            int col = pos[1];
            if (!visited[row][col]) {
                visited[row][col] = true;
                if (isValid(board, row, col) && board[row][col] == c &&
                        searchWord(board, word, index + 1, charMap, visited))
                    return true;
                visited[row][col] = false;
            }
        }

        return false;
    }

    // Helper method to check if a position is valid on the board
    private boolean isValid(char[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }
}
