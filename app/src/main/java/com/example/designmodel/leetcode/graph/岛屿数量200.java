package com.example.designmodel.leetcode.graph;

/**
 * 深度优先遍历
 */
public class 岛屿数量200 {
    private static final String TAG = "岛屿数量200";

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int landCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    landCount++;
                    dfs(grid, i, j);
                }
            }
        }
        return landCount;
    }

    // 此代码为模板
    private void dfs(char[][] grid, int i, int j) {
        int rl = grid.length;
        int cl = grid[0].length;
        if (i < 0 || j < 0 || i >= rl || j >= cl || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }


}
