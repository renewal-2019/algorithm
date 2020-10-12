package leecode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断二叉树是否镜像对称(实际上是判断两颗二叉树是否对称)
 */
public class Symmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;

        return check(root.left,root.right);
    }

    /**
     * 递归解法
     * @param node1
     * @param node2
     * @return
     */
    public boolean check(TreeNode node1,TreeNode node2){
        if(node1 == null && node2 == null)
            return true;
        if(node1 == null || node2 == null)
            return false;

        return node1.val == node2.val && check(node1.left,node2.right) && check(node1.right,node2.left);
    }

    public boolean isSymmetricX(TreeNode root){
        if(root == null)
            return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if(node1 == null && node2 == null)
//                return true;
                continue;//因为队列还没有清空,所以不能直接return
            if((node1 == null || node2 == null) || (node1.val != node2.val))
                return false;

            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }
}
