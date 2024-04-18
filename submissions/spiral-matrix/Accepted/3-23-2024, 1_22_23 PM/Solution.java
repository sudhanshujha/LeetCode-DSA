// https://leetcode.com/problems/spiral-matrix

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralOrder = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return spiralOrder;
        }
        
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        
        while (top <= bottom && left <= right) {
            // left to right
            for (int j = left; j <= right; j++) {
                spiralOrder.add(matrix[top][j]);
            }
            top++;
            
            // top to bottom
            for (int i = top; i <= bottom; i++) {
                spiralOrder.add(matrix[i][right]);
            }
            right--;
            
            // right to left
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    spiralOrder.add(matrix[bottom][j]);
                }
                bottom--;
            }
            
            // bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    spiralOrder.add(matrix[i][left]);
                }
                left++;
            }
        }
        return spiralOrder;
    }
}
