package leecode.august2020;

//将一个按照升序排列的有序数组
//        转换为一棵高度平衡二叉搜索树(一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1)
public class A26 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);

    }
    TreeNode helper(int[] nums,int left,int right){
        if(left > right){
            return null;
        }
        int mid = (left + right)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left= helper(nums,left,mid - 1);
        node.right=helper(nums,mid+ 1,right);
        return node;
    }
}
