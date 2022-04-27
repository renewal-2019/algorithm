package 广度优先搜索bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 你现在手里有一份大小为 n \times nn×n 的地图网格 grid，上面的每个单元格都标记为 0 或者 1，其中 0 代表海洋，1 代表陆地，
 * 请你找出一个海洋区域，这个海洋区域到离它最近的陆地区域的距离是最大的。
 */
public class 离开陆地的最远距离 {
    public static void main(String[] args) {
        int[][] gird = {
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 1}
        };

        System.out.println(maxDistance(gird));
    }

    // 多源BFS
    public static int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new ArrayDeque<>();
        // 将所有的陆地格子加入到队列中
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        // 只有海洋或者只有陆地，返回-1
        if (queue.isEmpty() || queue.size() == n * n) {
            return -1;
        }
        // 记录移动方向
        int[][] moves = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };
        // 当前遍历的层数，也是距离
        int distance = -1;
        while (!queue.isEmpty()) {
            distance++;
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                int[] node = queue.poll();
                int r = node[0];
                int c = node[1];
                for (int[] move : moves) {
                    int r2 = r + move[0];
                    int c2 = c + move[1];
                    if (inArea(grid, r2, c2) && grid[r2][c2] == 0) {
                        grid[r2][c2] = 2;
                        queue.add(new int[]{r2, c2});
                    }
                }
            }
        }
        return distance;
    }

    // 判断坐标 (r, c) 是否在网格中
    private static boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
    }
}
