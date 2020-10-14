package leecode.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Traversal {
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();

        traver(root,result);

        return result;
    }

    /**
     * 前序遍历
     * @param node
     * @param list
     */
    public void traver(TreeNode node,List<Integer> list){
        if(node == null)
            return;
        list.add(node.val);
        traver(node.left,list);
        traver(node.right,list);
    }

    //中序遍历
    public void traverMid(TreeNode node,List<Integer> list){
        if(node == null)
            return;

        traver(node.left,list);
        list.add(node.val);
        traver(node.right,list);
    }

    //后序遍历
    public void traverEnd(TreeNode node,List<Integer> list){
        if(node == null)
            return;

        traver(node.left,list);
        traver(node.right,list);
        list.add(node.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n11 = new TreeNode(21);
        TreeNode n12 = new TreeNode(22);
        root.left = n1;
        root.right = n2;
        n1.left = n11;
        n1.right = n12;

        System.out.println(Arrays.toString(new Traversal().preOrderTraversal(root).toArray()));
    }
}
