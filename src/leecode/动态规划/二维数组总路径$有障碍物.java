package leecode.动态规划;

public class 二维数组总路径$有障碍物 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] all = new int[m][n];
        for (int i = 0; i < n; i++){
            if(obstacleGrid[0][i] == 0)
            all[0][i] = 1;
        }

        for (int i = 0; i < m; i++)
            if(obstacleGrid[i][0] == 0)
                all[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
//                if(obstacleGrid[i][j] == 0)
//                all[i][j] = all[i - 1][j] + all[i][j - 1];
                all[i][j] = obstacleGrid[i][j] == 0 ?  all[i - 1][j] + all[i][j - 1] : 0;
            }
        }

        return all[m - 1][n - 1];
    }
}
