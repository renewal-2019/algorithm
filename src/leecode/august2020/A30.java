package leecode.august2020;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 */
public class A30 {
    /**
     * 广度优先算法
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> queueVal = new LinkedList<Integer>();
        queue.offer(root);
        queueVal.offer(root.val);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            int temp = queueVal.poll();
            if(node.left == null && node.right == null){
                if (sum == temp){
                    return true;
                }
                continue;
            }
            if(node.left != null){
                queue.offer(node.left);
                queueVal.offer(node.left.val + temp);
            }
            if(node.right != null){
                queue.offer(node.right);
                queueVal.offer(node.right.val + temp);
            }
        }
        return false;

    }

    /**
     * 递归
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum2(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.right == null && root.left == null){
            return root.val == sum;
        }

        return hasPathSum2(root.left,sum -root.val)|| hasPathSum2(root.right , sum - root.val);
    }
}
