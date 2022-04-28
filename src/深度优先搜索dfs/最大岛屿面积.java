package 深度优先搜索dfs;

public class 最大岛屿面积 {
    public static void main(String[] args) {
        int[][] island = {
                {0, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };
        System.out.println(maxSizeOfIsland(island));
    }

    private static int maxSizeOfIsland(int[][] island) {
        int res = 0;
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[0].length; j++) {
                if (island[i][j] == 1) {
                    int area = dfs(island, j, i);
                    res = Math.max(res, area);
                }
            }
        }
        return res;
    }

    private static int dfs(int[][] island, int x, int y) {
        if (x < 0 || y < 0 || x > island[0].length - 1 || y > island.length - 1) {
            return 0;
        }
        // 碰到海洋或者已计算过的陆地则直接返回
        if (island[y][x] != 1) {
            return 0;
        }
        // 将陆地标记为已计算过
        island[y][x] = 2;
        // 给面积加一
        return 1 + dfs(island, x - 1, y)
                + dfs(island, x + 1, y)
                + dfs(island, x, y - 1)
                + dfs(island, x, y + 1);
    }
}
