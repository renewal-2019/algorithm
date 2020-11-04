package leecode.动态规划;

public class 二维数组最小路径 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;
        int[][] all = new int[m][n];
        all[0][0] = grid[0][0];
        for (int i = 1; i < n; i++)
            all[0][i] = all[0][i - 1] + grid[0][i];
        for (int i = 1; i < m; i++)
            all[i][0] = all[i - 1][0] + grid[i][0];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                all[i][j] = Math.min(all[i - 1][j], all[i][j - 1]) + grid[i][j];
            }
        }

        return all[m - 1][n - 1];
    }
}
