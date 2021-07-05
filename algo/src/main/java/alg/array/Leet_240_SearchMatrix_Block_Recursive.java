package alg.array;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/sou-suo-er-wei-ju-zhen-ii-by-leetcode-2/
 */
public class Leet_240_SearchMatrix_Block_Recursive {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println(new Leet_240_SearchMatrix_Block_Recursive().findNumberIn2DArray(matrix, 20));
        System.out.println(new Leet_240_SearchMatrix_Block_Recursive().findNumberIn2DArray(matrix, 22));
        System.out.println(new Leet_240_SearchMatrix_Block_Recursive().findNumberIn2DArray(matrix, 25));
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        return searchMatrix(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, target);
    }


    private boolean searchMatrix(int[][] matrix, int startRow, int startCol, int endRow, int endCol, int target) {
        if (endRow < startRow || endCol < startCol) {
            return false;
        }

        int shortSize = Math.min(endRow - startRow, endCol - startCol) + 1;
        int position = findPositionUsingQuickFind(matrix, startRow, startCol, shortSize, target);

        if (position == -1) {
            return false;
        }

        if (matrix[startRow + position][startCol + position] == target) {
            return true;
        }

        //搜索右上区域
         return (searchMatrix(matrix, startRow, startCol + position + 1, startRow + position, endCol, target)) ||
                 searchMatrix(matrix, startRow + position + 1, startCol, endRow, startCol + position, target);
       
    }

    private int findPositionUsingQuickFind(int[][] matrix, int startRow, int startCol, int shortSize, int target) {
        int i = 0;
        while (i < shortSize && matrix[startRow + i][startCol + i] <= target) {
            i++;
        }

        return i - 1;
    }
}
