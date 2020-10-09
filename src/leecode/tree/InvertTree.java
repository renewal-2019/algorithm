package leecode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 反转二叉树
 */
public class InvertTree {
    /**
     * 深度优先(递归)
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * 广度优先
     * @param root
     * @return
     */
    public TreeNode invertTreeX(TreeNode root){
        if(root == null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();

            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;

            if(root.left != null){
                queue.offer(root.left);
            }
            if(root.right != null){
                queue.offer(root.right);
            }
        }

        return root;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
