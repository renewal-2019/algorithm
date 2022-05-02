package 深度优先搜索dfs;

/**
 * 1代表有子， 0代表空格
 * 求被围住的空格有多少个
 */
public class 围棋之被围空格 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1},
                {0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0}
        };
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(grid, j, i)) {
                        System.out.println("封闭岛屿");
                    }
                }
            }
        }

    }

    // 判断标准：如果在没有到达边界的情况下返回那就是封闭的，如果在到达边界的情况下返回那就不是封闭的
    // 只要有一个dfs是在边界返回的，那就不是封闭的
    private static boolean dfs(int[][] grid, int x, int y) {
        // 当前为边界并且格子是空的，说明探到边界了，那么就不是封闭的，直接返回false
        if ((x == 0 || y == 0 || x == grid[0].length - 1 || y == grid.length - 1) && grid[y][x] == 0) {
            return false;
        }
        // 此次dfs的返回值
        boolean flag = true;
        // 将空格标记为已计算过
        grid[y][x] = 1;
        // 对四个方向依次进行探测
        int exec = 0;
        for (int i = 0; i < 4; i++) {
            int x1 = x + dx[i];
            int y1 = y + dy[i];
            // 如果他的下一次探测位置超出边界了或者下一次探测位置不是空格，那么那个方向就不需要进行探测了
            if (x1 < 0 || x1 > grid[0].length - 1 || y1 > grid.length - 1 || grid[y1][x1] == 1) {
                continue;
            }
            flag = flag & dfs(grid, x1, y1);
        }
        return flag;
    }
}
