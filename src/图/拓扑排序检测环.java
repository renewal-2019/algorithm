package 图;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 检测有向图是否成环
 */
public class 拓扑排序检测环 {
    public static void main(String[] args) {
        int[][] prerequisites = {
                {0, 1},
                {3, 1},
                {3, 2},
                {2, 1}
        };
        System.out.println(canFinish(4, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses);
        // 构造有向图
        for (int[] item : prerequisites) {
            graph.addEdge(item[0], item[1]);
        }
        LinkedList<Integer>[] adj = graph.getAdj();  // 有向图
        // 统计每个定点的入度
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                Integer w = adj[i].get(j);
                inDegree[w]++;
            }
        }
        // 将所有入度为0的定点入队
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }
        // 存储最终入度为0的定点的个数
        int zd = 0;
        while (!queue.isEmpty()) {
            Integer remove = queue.remove();
            zd++;
            for (int i = 0; i < adj[remove].size(); i++) {
                Integer in = adj[remove].get(i);
                inDegree[in]--;
                if (inDegree[in] == 0) {
                    queue.add(in);
                }
            }
        }
        return zd == numCourses;
    }
}
