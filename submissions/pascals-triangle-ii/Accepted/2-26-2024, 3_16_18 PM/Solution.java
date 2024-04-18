// https://leetcode.com/problems/pascals-triangle-ii

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        for (int row = 0; row <= rowIndex; row++) {
            List<Integer> rowList = new ArrayList<>();

            for (int col = 0; col < row + 1; col++) {
                if (col == 0 || col == row) {
                    rowList.add(1);
                } else {
                    int sum = pascalTriangle.get(row - 1).get(col - 1) + pascalTriangle.get(row - 1).get(col);
                    rowList.add(sum);
                }
            }

            pascalTriangle.add(rowList);
        }

        return pascalTriangle.get(rowIndex);
    }
}