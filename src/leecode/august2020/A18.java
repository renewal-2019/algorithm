package leecode.august2020;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数
 */
public class A18 {

    /**
     * 递归求解
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNodeXX root) {
        int count = 0;
        if (root == null) {
            return count;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * 广度优先算法
     *我们也可以用「广度优先搜索」的方法来解决这道题目，但我们需要对其进行一些修改，此时我们广度优先搜索的队列里存放的是「当前层的所有节点」。
     * 每次拓展下一层的时候，不同于广度优先搜索的每次只从队列里拿出一个节点，
     * 我们需要将队列里的所有节点都拿出来进行拓展，这样能保证每次拓展完的时候队列里存放的是当前层的所有节点，
     * 即我们是一层一层地进行拓展，最后我们用一个变量 \textit{ans}ans 来维护拓展的次数，该二叉树的最大深度即为 \textit{ans}ans。
     * @param root
     * @return
     */
    public int maxDepthX(TreeNodeXX root) {
        int count = 0;
        if (root == null) {
            return count;
        }

        Queue<TreeNodeXX> queue = new LinkedList<TreeNodeXX>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNodeXX treeNodeXX = queue.poll();
                if (treeNodeXX.left != null) {
                    queue.offer(treeNodeXX.left);
                }
                if (treeNodeXX.right != null) {
                    queue.offer(treeNodeXX.right);
                }
                size--;
            }
            count++;
        }
        return count;
    }

}

class TreeNodeXX {
    int val;
    TreeNodeXX left;
    TreeNodeXX right;

    TreeNodeXX(int x) {
        val = x;
    }
}
