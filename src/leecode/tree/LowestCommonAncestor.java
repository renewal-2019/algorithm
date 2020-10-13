package leecode.tree;

import java.util.LinkedList;
import java.util.List;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = getPath(root,p);
        List<TreeNode> list2 = getPath(root,q);

        TreeNode result = root;
        for(int i = 0;i< list1.size() && i < list2.size();i++){
            if(list1.get(i) == list2.get(i)){
                result = list1.get(i);
            }else {
                break;
            }
        }

        return result;
    }

    public List<TreeNode> getPath(TreeNode root , TreeNode node){
        List<TreeNode> list = new LinkedList<>();
        while (root != node){
            list.add(root);
            if(root.val > node.val){
                root = root.left;
            }else {
                root = root.right;
            }
        }

        list.add(root);

        return list;
    }


    /**
     * 充分利用二叉搜索树的特性,只需进行一次遍历
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorX(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }
}
