package leecode.august2020;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
public class A20 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resultList = new LinkedList<>();

        if (root == null) {
            return resultList;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            while (size > 0){
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if(treeNode.left != null){
                    queue.offer(treeNode.left);
                }
                if(treeNode.right != null){
                    queue.offer(treeNode.right);
                }
                size--;
            }
            resultList.add(list);
        }

        List<List<Integer>> resultListX = new LinkedList<>();
        for(int i = resultList.size()-1; i>= 0; i--){
            resultListX.add(resultList.get(i));
        }

        return resultListX;
    }

}
