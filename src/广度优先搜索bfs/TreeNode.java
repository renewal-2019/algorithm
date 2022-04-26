package 广度优先搜索bfs;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    void addLeft(TreeNode left) {
        this.left = left;
    }

    void addRight(TreeNode right) {
        this.right = right;
    }
}
