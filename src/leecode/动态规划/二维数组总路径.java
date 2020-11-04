package leecode.动态规划;

/**
 * leecode 61
 */
public class 二维数组总路径 {
    public int allPathNumber(int m, int n) {
        int[][] all = new int[m][n];
        for (int i = 0; i < n; i++)
            all[0][i] = 1;
        for (int i = 0; i < m; i++)
            all[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                all[i][j] = all[i - 1][j] + all[i][j - 1];
            }
        }

        return all[m - 1][n - 1];
    }
}
