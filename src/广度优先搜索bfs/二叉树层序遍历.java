package 广度优先搜索bfs;

import java.util.*;

public class 二叉树层序遍历 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.addLeft(treeNode2);
        treeNode.addRight(treeNode3);
        List<List<Integer>> lists = levelOrder(treeNode);
        lists.stream().forEach(item -> System.out.println(Arrays.toString(item.toArray())));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            // n记录当前队列的大小，即代表每一层的点个数，然后一次性取出队列中的n个元素，也就是正好取出了一层的点
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
