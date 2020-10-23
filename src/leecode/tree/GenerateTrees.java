package leecode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树
 */
public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end){
            allTrees.add(null);
            return allTrees;
        }


        //枚举所有可行的节点
        for(int i = start; i <= end; i++){
            //获取所有左子树集合
            List<TreeNode> leftTree = generateTrees(start,i-1);
            //获取所有右子树集合
            List<TreeNode> rightTree = generateTrees(i+1,end);

            //从左集合选一颗,从右集合选一颗,拼接到根节点
            for(TreeNode leftTreeNode : leftTree){
                for(TreeNode rightTreeNode : rightTree){
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftTreeNode;
                    treeNode.right = rightTreeNode;
                    allTrees.add(treeNode);
                }
            }
        }


        return allTrees;
    }
}
