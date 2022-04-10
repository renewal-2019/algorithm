package 递归;

import java.util.ArrayList;
import java.util.List;

public class 课程表 {
    public static void main(String[] args) {
        int[][] res = new int[3][2];
        res[0][0] = 1;
        res[0][1] = 0;
        res[1][0] = 1;
        res[1][1] = 2;
        res[2][0] = 0;
        res[2][1] = 1;
        System.out.println(canFinish(3, res));
    }

    static List<List<Integer>> edges;
    static int[] visited;
    static boolean valid = true;

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            // 以先学课程为序列，list的中的点为该先学课程对应的后学课程
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; ++i) {
            // 如果该点没有被搜索过，则进行搜索
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public static void dfs(int u) {
        // 将该先学课程标记为搜索中
        visited[u] = 1;
        // 遍历该先学课程所应对的所有后学课程
        for (int v : edges.get(u)) {
            // 如果这个后学课程还没有搜索过，则进行搜索
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) { // 目前认为只是为了提高效率，减少计算次数
                    return;
                }
            } else if (visited[v] == 1) { // 如果这个点在搜索中，说明形成了环，那么则说明课程不可能学成
                valid = false;
                return;
            }
        }
        // 将此先学课程标记为搜索完成
        visited[u] = 2;
    }
}
