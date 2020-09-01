package leecode.august2020;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断二叉树的最小深度
 */
public class A29 {

    public int minDepth(TreeNode root) {
        int height = 0;
        if (root == null) {
            return height;
        }

        Queue<TreeNode> nodeList = new LinkedList<TreeNode>();
        nodeList.offer(root);

        while (!nodeList.isEmpty()) {
            int size = nodeList.size();
            while (size > 0) {
                TreeNode node = nodeList.poll();
                if (node.left == null && node.right == null) {
                    return height + 1;
                }
                if (node.left != null) {
                    nodeList.offer(node.left);
                }
                if (node.right != null) {
                    nodeList.offer(node.right);
                }
                size--;
            }
            height++;
        }
        return height;
    }

}
