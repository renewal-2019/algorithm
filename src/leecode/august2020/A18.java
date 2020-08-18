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
     *
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
