package org.barry.algorithm.hot100;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/2/25 15:08
 */
public class P200 {
    public int numIslands(char[][] grid) {
        int ans = 0;
        int height = grid.length, width = grid[0].length;
        boolean[][] used = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!used[i][j] && grid[i][j] == '1') {
                    bfs(used, grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void bfs(boolean[][] used, char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || used[i][j] || grid[i][j] == '0') {
            return;
        }
        used[i][j] = true;
        bfs(used, grid, i - 1, j);
        bfs(used, grid, i + 1, j);
        bfs(used, grid, i, j - 1);
        bfs(used, grid, i, j + 1);
    }
}
