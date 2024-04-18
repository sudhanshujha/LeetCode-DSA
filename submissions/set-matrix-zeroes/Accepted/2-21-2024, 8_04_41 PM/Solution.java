// https://leetcode.com/problems/set-matrix-zeroes

class Solution {
    public void setZeroes(int[][] matrix) {
        // Goal: Find all the cells with zeroes
        // Find all those rows & columns, store them & update them
        
        boolean[] zeroRows = new boolean[matrix.length];
        boolean[] zeroCols = new boolean[matrix[0].length];
        
        // Iterate over the matrix & find all zeroes
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }
        
        // Update the matrix based on zeroRows & zeroCols
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(zeroRows[i] || zeroCols[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
