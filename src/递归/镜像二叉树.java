package 递归;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class 镜像二叉树 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}