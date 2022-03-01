package org.barry.algorithm.hot100;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/3/1 18:08
 */
public class P240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length, width = matrix[0].length;
        int i = 0, j = width - 1;
        while (i < height && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
