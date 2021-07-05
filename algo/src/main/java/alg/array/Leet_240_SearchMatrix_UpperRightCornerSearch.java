package alg.array;

/**
 *     https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/solution/mian-shi-ti-04-er-wei-shu-zu-zhong-de-cha-zhao-b-3/
 */
public class Leet_240_SearchMatrix_UpperRightCornerSearch {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println(new Leet_240_SearchMatrix_UpperRightCornerSearch().findNumberIn2DArray(matrix, 20));
        System.out.println(new Leet_240_SearchMatrix_UpperRightCornerSearch().findNumberIn2DArray(matrix, 22));
        System.out.println(new Leet_240_SearchMatrix_UpperRightCornerSearch().findNumberIn2DArray(matrix, 25));
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                //找寻这个列位置的过程中，可以使用二分搜索法加速。
                column--;
            } else {
                //找寻这个行位置的过程中，可以使用二分搜索法加速。
                row++;
            }
        }
        return false;
    }
}
