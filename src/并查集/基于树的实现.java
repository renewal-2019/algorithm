package 并查集;

public class 基于树的实现 {
    public static void main(String[] args) {
        TreeUnionFindSet treeUnionFindSet = new TreeUnionFindSet(4);
        treeUnionFindSet.union(0, 1);
        treeUnionFindSet.union(1, 2);
        treeUnionFindSet.union(2, 3);
        treeUnionFindSet.union(3, 0);
    }
}

class TreeUnionFindSet {
    // 记录父节点的数组，索引代表定点，索引位置上的值代表这个定点的父节点
    private int[] p;

    public TreeUnionFindSet(int n) {
        p = new int[n];
        // 初始化并查集
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
    }

    public void union(int i, int j) {
        if (find(i, j)) {
            System.out.println(i + "," + j + "已在同一集合中");
            return;
        }
        p[findR(i)] = findR(j);
    }

    // 查找是否在同一集合中
    public boolean find(int i, int j) {
        return findR(i) == findR(j);
    }

    // 查找集合中的代表（当前节点的根节点）
    // 路径压缩
    public int findR(int i) {
        if (p[i] != i) {
            return findR(p[i]);
        }
        return i;
    }
}
