package org.barry.algorithm.hot100;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/2/14 17:10
 */
public class P079 {
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int width = board[0].length;
        int height = board.length;
        boolean[][] used = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (dfs(board, i, j, chars, 0, used)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] chars, int index, boolean[][] used) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || index >= chars.length || chars[index] != board[i][j] || used[i][j]) {
            return false;
        }
        if (index == chars.length - 1 && chars[index] == board[i][j]) {
            return true;
        }
        used[i][j] = true;
        boolean left = dfs(board, i - 1, j, chars, index + 1, used);
        boolean right = dfs(board, i + 1, j, chars, index + 1, used);
        boolean top = dfs(board, i, j - 1, chars, index + 1, used);
        boolean bottom = dfs(board, i, j + 1, chars, index + 1, used);
        used[i][j] = false;
        return left || right || top || bottom;

    }
}
