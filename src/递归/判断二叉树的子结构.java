package 递归;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
public class 判断二叉树的子结构 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean isSub(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return isSub(A.left, B.left) && isSub(A.right, B.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
