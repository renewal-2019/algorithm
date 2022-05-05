package 树;

public class 前序遍历 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.addLeft(new TreeNode(2));
        root.addRight(new TreeNode(3));
        root.getLeft().addLeft(new TreeNode(4));
        root.getLeft().addRight(new TreeNode(5));
        dfs(root);
    }

    // 前序遍历
    private static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.getValue());
        dfs(root.getLeft());
        dfs(root.getRight());
    }
}
