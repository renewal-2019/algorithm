package 图;

import java.util.LinkedList;

/**
 * 有向图的邻接表表示法
 */
public class Graph {
    /**
     * 定点个数
     */
    private int vertexNum;

    private LinkedList<Integer>[] adj; //邻接表

    public Graph(int vertexNum) {
        this.vertexNum = vertexNum;
        adj = new LinkedList[vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) { // 有向图只存一边
        adj[s].add(t);
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }
}
