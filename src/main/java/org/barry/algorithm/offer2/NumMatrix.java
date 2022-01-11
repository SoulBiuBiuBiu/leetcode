package org.barry.algorithm.offer2;

/**
 * P013
 *
 * @author Barry
 * @since 2022/1/10 10:49
 */
public class NumMatrix {
    int[][] pre;
    int width, height;
    int sum = 0;
    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        width = matrix[0].length;
        height = matrix.length;
        pre = new int[height][width];
        sum = 0;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                pre[row][col] = sum;
                sum += matrix[row][col];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int row = row1; row <= row2; row++) {
            res += pre[row][col2] - pre[row][col1] + matrix[row][col2];
        }
        return res;
    }
}
