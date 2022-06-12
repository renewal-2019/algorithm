package 动态规划;

/**
 * https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/solution/mian-shi-ti-47-li-wu-de-zui-da-jie-zhi-dong-tai-gu/
 *
 * grid(i,j)+max[dp(i−1,j),dp(i,j−1)]
 */
public class 二维数组中的最大路径和 {
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int j = 1; j < n; j++) // 初始化第一行
            grid[0][j] += grid[0][j - 1];
        for (int i = 1; i < m; i++) // 初始化第一列
            grid[i][0] += grid[i - 1][0];
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
        return grid[m - 1][n - 1];
    }
}
