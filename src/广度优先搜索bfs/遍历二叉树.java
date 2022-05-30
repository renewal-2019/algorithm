package 广度优先搜索bfs;

import java.util.*;

public class 遍历二叉树 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(root);
        List<Integer> res = new ArrayList<>();
        while (!nodeQueue.isEmpty()) {
            TreeNode poll = nodeQueue.poll();
            res.add(poll.val);
            if (poll.left != null) {
                nodeQueue.add(poll.left);
            }
            if (poll.right != null) {
                nodeQueue.add(poll.right);
            }
        }
        int[] ints = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ints[i] = res.get(i);
        }
        return ints;
    }
}
