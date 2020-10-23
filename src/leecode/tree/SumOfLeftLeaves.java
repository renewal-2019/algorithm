package leecode.tree;

public class SumOfLeftLeaves {
    /**
     * 所有左节点之和
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null)
            return sum;
        if (root.left != null){
            sum += root.left.val;
            sum += sumOfLeftLeaves(root.left);
        }

        if(root.right != null)
            sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    public int sumOfLeftButtonLeaves(TreeNode root) {
        return root == null ? 0 : dfs(root);
    }

    /**
     * 所有左叶子节点
     * @param node
     * @return
     */
    public int dfs(TreeNode node){
        int num = 0;
        if(node.left != null )
            num += isLeaf(node.left) ? node.left.val : dfs(node.left);
        if(node.right != null)
            num += dfs(node.right);

        return num;
    }

    public boolean isLeaf(TreeNode node){
        if(node.left == null && node.right == null)
            return true;
        return false;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        TreeNode tree1 = new TreeNode(1);
        TreeNode tree2 = new TreeNode(1);
        TreeNode tree3 = new TreeNode(1);
        TreeNode tree4 = new TreeNode(1);
        TreeNode tree5 = new TreeNode(1);
        TreeNode tree6 = new TreeNode(1);
        TreeNode tree7 = new TreeNode(1);
        TreeNode tree8 = new TreeNode(1);
        tree.left = tree1;
        tree.right = tree2;
        tree1.left = tree3;
        tree1.right = tree4;
        tree2.left = tree5;
        tree2.right = tree6;
        tree5.left = tree7;
        tree7.left = tree8;

        System.out.println(new SumOfLeftLeaves().sumOfLeftLeaves(tree));
    }

}
