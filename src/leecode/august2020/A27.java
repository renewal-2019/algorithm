package leecode.august2020;

/**
 * 判断二叉树是否绝对平衡
 */
public class A27 {

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        return Math.abs(height(root.left)-height(root.right)) <= 1 && isBalanced(root.right) && isBalanced(root.left);
    }

    int height(TreeNode root){
        if(root == null){
            return 0;
        }
         return Math.max(height(root.left),height(root.right)) + 1;
    }
}
