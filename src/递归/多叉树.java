package 递归;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 函数public int[][][] findPath(int[] trees)
 * trees数组的索引代表每棵树的id, 值代表树的父节点id, 如果为-1就是根节点（默认id=0的树是根节点）, 每棵树只会有一个父节点
 * int[] trees = {-1, 0, 0, 1, 1, 1, 2, 6};
 * 返回值int[x][y][z]为三维数组, 前两位代表起始点和结束点, 最后一维数组为包含起始结束点id的路径数组
 * <p>
 * 以如上图为例
 * path[4][7] = 4, 1, 0, 2, 6, 7
 * path[7][3] = 7, 6, 2, 0, 1, 3
 * path[1][1] = 1
 */

public class 多叉树 {
    public static void main(String[] args) {
        int[] tree = new int[]{-1, 0, 0, 1, 1, 1, 2, 6};
        int[][][] res = new int[tree.length][tree.length][];
        for (int i = 0; i < tree.length; i++) {
            for (int j = tree.length - 1; j >= 0; j--) {
                if (i == j) {
                    res[i][i] = new int[]{i};
                    System.out.println(i + " " + j);
                    System.out.println(Arrays.toString(res[i][j]));
                    continue;
                }
                if (j < i) {
                    // 说明已经计算过了，直接倒序一下就行
                    res[i][j] = reserve(res[j][i]);
                    System.out.println(i + " " + j);
                    System.out.println(Arrays.toString(res[i][j]));
                    continue;
                }
                List<Integer> path1 = new ArrayList<>();
                path1 = dfsRoot(tree, path1, i);
                List<Integer> path2 = new ArrayList<>();
                path2 = dfsRoot(tree, path2, j);
                res[i][j] = findIntersection(path1, path2);
                System.out.println(i + " " + j);
                System.out.println(Arrays.toString(res[i][j]));
            }
        }
    }

    // 找到开始节点到根节点的路径; path中的初始值为开始节点
    private static List<Integer> dfsRoot(int[] tree, List<Integer> path, int current) {
        if (path.size() == 0) {
            path.add(current);
        }
        if (current == 0) {
            return path;
        }
        // 找当前节点的父节点
        Integer fatherNode = tree[current];
        path.add(fatherNode);
        return dfsRoot(tree, path, fatherNode);
    }

    // 找出两条路径的交点位置，并合并路线
    // 使用双指针，path1的指针从头开始，path2的指针从尾开始
    private static int[] findIntersection(List<Integer> path1, List<Integer> path2) {
        for (int i = 0; i < path1.size(); i++) {
            for (int j = path2.size() - 1; j >= 0; j--) {
                if (path1.get(i) == path2.get(j)) {
                    List<Integer> intersection = new ArrayList<>();
                    int index = 0;
                    while (index <= i) {
                        intersection.add(path1.get(index++));
                    }
                    index = j - 1;
                    while (index >= 0) {
                        intersection.add(path2.get(index--));
                    }
                    Integer[] as = intersection.toArray(new Integer[intersection.size()]);
                    int[] res = new int[as.length];
                    for (int n = 0; n < as.length; n++) {
                        res[n] = as[n];
                    }
                    return res;
                }
            }
        }
        return null;
    }

    private static int[] reserve(int[] array) {
        int[] res = new int[array.length];
        int index = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            res[index++] = array[i];
        }
        return res;
    }
}
